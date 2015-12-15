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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.03.27 at 03:31:20 PM GMT
//


package org.apache.wss4j.binding.wss10;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.apache.wss4j.binding.wss10 package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private static final String WSSE_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final QName _Nonce_QNAME = new QName(WSSE_NS, "Nonce");
    private static final QName _Reference_QNAME = new QName(WSSE_NS, "Reference");
    private static final QName _BinarySecurityToken_QNAME = new QName(WSSE_NS, "BinarySecurityToken");
    private static final QName _UsernameToken_QNAME = new QName(WSSE_NS, "UsernameToken");
    private static final QName _KeyIdentifier_QNAME = new QName(WSSE_NS, "KeyIdentifier");
    private static final QName _Embedded_QNAME = new QName(WSSE_NS, "Embedded");
    private static final QName _Security_QNAME = new QName(WSSE_NS, "Security");
    private static final QName _SecurityTokenReference_QNAME = new QName(WSSE_NS, "SecurityTokenReference");
    private static final QName _Password_QNAME = new QName(WSSE_NS, "Password");
    private static final QName _TransformationParameters_QNAME = new QName(WSSE_NS, "TransformationParameters");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.wss4j.binding.wss10
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SecurityHeaderType }
     *
     */
    public SecurityHeaderType createSecurityHeaderType() {
        return new SecurityHeaderType();
    }

    /**
     * Create an instance of {@link EmbeddedType }
     *
     */
    public EmbeddedType createEmbeddedType() {
        return new EmbeddedType();
    }

    /**
     * Create an instance of {@link TransformationParametersType }
     *
     */
    public TransformationParametersType createTransformationParametersType() {
        return new TransformationParametersType();
    }

    /**
     * Create an instance of {@link PasswordString }
     *
     */
    public PasswordString createPasswordString() {
        return new PasswordString();
    }

    /**
     * Create an instance of {@link SecurityTokenReferenceType }
     *
     */
    public SecurityTokenReferenceType createSecurityTokenReferenceType() {
        return new SecurityTokenReferenceType();
    }

    /**
     * Create an instance of {@link UsernameTokenType }
     *
     */
    public UsernameTokenType createUsernameTokenType() {
        return new UsernameTokenType();
    }

    /**
     * Create an instance of {@link BinarySecurityTokenType }
     *
     */
    public BinarySecurityTokenType createBinarySecurityTokenType() {
        return new BinarySecurityTokenType();
    }

    /**
     * Create an instance of {@link ReferenceType }
     *
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link EncodedString }
     *
     */
    public EncodedString createEncodedString() {
        return new EncodedString();
    }

    /**
     * Create an instance of {@link KeyIdentifierType }
     *
     */
    public KeyIdentifierType createKeyIdentifierType() {
        return new KeyIdentifierType();
    }

    /**
     * Create an instance of {@link AttributedString }
     *
     */
    public AttributedString createAttributedString() {
        return new AttributedString();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncodedString }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "Nonce")
    public JAXBElement<EncodedString> createNonce(EncodedString value) {
        return new JAXBElement<EncodedString>(_Nonce_QNAME, EncodedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "Reference")
    public JAXBElement<ReferenceType> createReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_Reference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinarySecurityTokenType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "BinarySecurityToken")
    public JAXBElement<BinarySecurityTokenType> createBinarySecurityToken(BinarySecurityTokenType value) {
        return new JAXBElement<BinarySecurityTokenType>(_BinarySecurityToken_QNAME, BinarySecurityTokenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsernameTokenType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "UsernameToken")
    public JAXBElement<UsernameTokenType> createUsernameToken(UsernameTokenType value) {
        return new JAXBElement<UsernameTokenType>(_UsernameToken_QNAME, UsernameTokenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyIdentifierType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "KeyIdentifier")
    public JAXBElement<KeyIdentifierType> createKeyIdentifier(KeyIdentifierType value) {
        return new JAXBElement<KeyIdentifierType>(_KeyIdentifier_QNAME, KeyIdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmbeddedType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "Embedded")
    public JAXBElement<EmbeddedType> createEmbedded(EmbeddedType value) {
        return new JAXBElement<EmbeddedType>(_Embedded_QNAME, EmbeddedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityHeaderType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "Security")
    public JAXBElement<SecurityHeaderType> createSecurity(SecurityHeaderType value) {
        return new JAXBElement<SecurityHeaderType>(_Security_QNAME, SecurityHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityTokenReferenceType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "SecurityTokenReference")
    public JAXBElement<SecurityTokenReferenceType> createSecurityTokenReference(SecurityTokenReferenceType value) {
        return new JAXBElement<SecurityTokenReferenceType>(_SecurityTokenReference_QNAME, SecurityTokenReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordString }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "Password")
    public JAXBElement<PasswordString> createPassword(PasswordString value) {
        return new JAXBElement<PasswordString>(_Password_QNAME, PasswordString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformationParametersType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = WSSE_NS, name = "TransformationParameters")
    public JAXBElement<TransformationParametersType> createTransformationParameters(TransformationParametersType value) {
        return new JAXBElement<TransformationParametersType>(_TransformationParameters_QNAME, TransformationParametersType.class, null, value);
    }

}
