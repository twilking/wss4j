/*
 * Copyright  2003-2004 The Apache Software Foundation.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.ws.security.components.crypto;

import org.apache.ws.security.WSSecurityException;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/**
 * Crypto.
 * <p/>
 * 
 * @author Davanum Srinivas (dims@yahoo.com).
 */
public interface Crypto {
    /**
     * load a X509Certificate from the input stream.
     * <p/>
     * 
     * @param The <code>InputStream</code> array containg the X509 data
     * @throws GeneralSecurityException 
     * @return	Returns a X509 certificate
     */
    X509Certificate loadCertificate(InputStream in) throws WSSecurityException;

    /**
     * Construct an array of X509Certificate's from the byte array.
     * <p/>
     * 
     * @param data    The <code>byte</code> array containg the X509 data
     * @param reverse If set the first certificate in input data will
     *                the last in the array
     * @throws IOException              
     * @throws GeneralSecurityException 
     * @return		An array of X509 certificates, ordered according to
     * the reverse flag
     */
    X509Certificate[] getX509Certificates(byte[] data, boolean reverse) throws WSSecurityException;

    /**
     * get a byte array given an array of X509 certificates.
     * <p/>
     * 
     * @param reverse If set the first certificate in the array data will
     *                the last in the byte array
     * @param certs   The certificates to convert
     * @throws IOException                  
     * @throws CertificateEncodingException 
     * @return		The byte array for the certficates ordered according
     * to the reverse flag
     */
    byte[] getCertificateData(boolean reverse, X509Certificate[] certs) throws WSSecurityException;

    /**
     * Gets the private key identified by <code>alias</> and <code>password</code>.
     * <p/>
     * 
     * @param alias    The alias (<code>KeyStore</code>) of the key owner
     * @param password The password needed to access the private key
     * @throws Exception 
     * @return		The private key
     */
    public PrivateKey getPrivateKey(String alias, String password) throws Exception;

    /**
     * get the list of certificates for a given alias. This method
     * reads a new certificate chain and overwrites a previously
     * stored certificate chain.
     * <p/>
     * 
     * @param alias Lookup certificate chain for this alias
     * @return Array of X509 certificates for this alias name, or
     *         null if this alias does not exist in the keystore
     */
    public X509Certificate[] getCertificates(String alias) throws WSSecurityException;

    /**
     * Return a X509 Certificate alias in the keystore according to a given Certificate
     * <p/>
     * 
     * @param cert The certificate to lookup
     * @return alias name of the certificate that matches the given certificate
     *         or null if no such certificate was found.
     *         <p/>
     *         See comment above
     *         <p/>
     *         See comment above
     */
    /*
     * See comment above
     */
    public String getAliasForX509Cert(Certificate cert) throws WSSecurityException;

    /**
     * Search a X509 Certificate in the keystore according to a given serial number and
     * the issuer of a Certficate.
     * <p/>
     * The search gets all alias names of the keystore and gets the certificate chain
     * for each alias. Then the SerialNumber and Issuer fo each certificate of the chain
     * is compared with the parameters.
     * 
     * @param issuer       The issuer's name for the certificate
     * @param serialNumber The serial number of the certificate from the named issuer
     * @return alias name of the certificate that matches serialNumber and issuer name
     *         or null if no such certificate was found.
     */
    public String getAliasForX509Cert(String issuer, BigInteger serialNumber) throws WSSecurityException;

	/**
	 * Lookup a X509 Certificate in the keystore according to a given 
	 * SubjectKeyIdentifier.
	 * <p/>
	 * The search gets all alias names of the keystore and gets the certificate chain
	 * or certificate for each alias. Then the SKI for each user certificate 
	 * is compared with the SKI parameter.
	 * 
	 * @param skiBytes       The SKI info bytes
	 * @return alias name of the certificate that matches serialNumber and issuer name
	 *         or null if no such certificate was found.
	 */
	public String getAliasForX509Cert(byte[] skiBytes) throws WSSecurityException;
	/**
	 * Reads the SubjectKeyIdentifier information from the certificate. 
	 * <p/> 
	 * 
	 * @param cert       The certificate to read SKI
	 * @return 			 The byte array conating the binary SKI data
	 */
	public byte[] getSKIBytesFromCert(X509Certificate cert)	throws WSSecurityException;

}
