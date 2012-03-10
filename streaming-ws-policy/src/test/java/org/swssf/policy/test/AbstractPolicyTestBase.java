/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.swssf.policy.test;

import org.apache.ws.secpolicy.SPConstants;
import org.apache.ws.secpolicy.WSSPolicyException;
import org.swssf.policy.PolicyEnforcer;
import org.swssf.policy.PolicyEnforcerFactory;
import org.swssf.wss.ext.WSSConstants;
import org.swssf.wss.impl.securityToken.X509SecurityToken;
import org.swssf.wss.test.AbstractTestBase;
import org.swssf.xmlsec.ext.XMLSecurityConstants;
import org.swssf.xmlsec.ext.XMLSecurityException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class AbstractPolicyTestBase extends AbstractTestBase {

    protected PolicyEnforcer buildAndStartPolicyEngine(String policyString) throws ParserConfigurationException, SAXException, IOException, WSSPolicyException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(false);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(this.getClass().getClassLoader().getResourceAsStream("testdata/wsdl/wsdl-template.wsdl"));
        NodeList nodeList = document.getElementsByTagNameNS("*", SPConstants.P_LOCALNAME);

        Document policyDocument = documentBuilder.parse(new ByteArrayInputStream(policyString.getBytes("UTF-8")));
        Node policyNode = document.importNode(policyDocument.getDocumentElement(), true);
        Element element = (Element) nodeList.item(0);
        element.appendChild(policyNode);
        PolicyEnforcerFactory policyEnforcerFactory = PolicyEnforcerFactory.newInstance(document);
        PolicyEnforcer policyEnforcer = policyEnforcerFactory.newPolicyEnforcer("");

        return policyEnforcer;
    }

    public X509SecurityToken getX509Token(WSSConstants.TokenType tokenType) throws Exception {

        final KeyStore keyStore = KeyStore.getInstance("jks");
        keyStore.load(this.getClass().getClassLoader().getResourceAsStream("transmitter.jks"), "default".toCharArray());

        return new X509SecurityToken(tokenType, null, null, null, "", WSSConstants.KeyIdentifierType.THUMBPRINT_IDENTIFIER) {
            @Override
            protected String getAlias() throws XMLSecurityException {
                return "transmitter";
            }

            @Override
            public Key getSecretKey(String algorithmURI, XMLSecurityConstants.KeyUsage keyUsage) throws XMLSecurityException {
                try {
                    return keyStore.getKey("transmitter", "default".toCharArray());
                } catch (Exception e) {
                    throw new XMLSecurityException(e.getMessage(), e);
                }
            }

            @Override
            public PublicKey getPublicKey(String algorithmURI, XMLSecurityConstants.KeyUsage keyUsage) throws XMLSecurityException {
                try {
                    return keyStore.getCertificate("transmitter").getPublicKey();
                } catch (Exception e) {
                    throw new XMLSecurityException(e.getMessage(), e);
                }
            }

            @Override
            public X509Certificate[] getX509Certificates() throws XMLSecurityException {
                Certificate[] certificates;
                try {
                    certificates = keyStore.getCertificateChain("transmitter");
                } catch (Exception e) {
                    throw new XMLSecurityException(e.getMessage(), e);
                }

                X509Certificate[] x509Certificates = new X509Certificate[certificates.length];
                for (int i = 0; i < certificates.length; i++) {
                    Certificate certificate = certificates[i];
                    x509Certificates[i] = (X509Certificate) certificate;
                }
                return x509Certificates;
            }
        };
    }
}