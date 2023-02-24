/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.util;

/**
 * Options for customizing the HttpClient.  The available HttpClient options provided by this class are:
 * 1. Trust All Certificates
 * 2. Keystore Provided (containing your client certificate and private key)
 * NOTE:  These options default to 'false' if not set.
 *
 * Trust All Certificates:  By default, SSL certificate verification is performed using a CA certificate store.  Ensuring
 * that the certificate is signed by a CA that is present in the store is how to verify that the remote server is who it claims
 * it is.  In the case of self-signed certificates, the server is using a certificate that may not be signed by one of the
 * CAs in the store.  In this case, attempting to establish a connection to the server will result in an SSLHandshakeException.
 * By configuring your HTTP Client options with 'trust all certificates' is one way to deal with self-signed certificates.
 * NOTE:  This mode is considered insecure with the possibility for a man-in-the-middle attack.
 *
 * Usage Example: HttpClientOptions httpOptions = new HttpClientOptions.Builder().trustAllCertificates(true).build();
 *
 * Keystore Provided:  If the endpoint that you are connecting to has Mutual TLS configured, as a Java client, you will be
 * required to provide a keystore.  The keystore will need to contain your client certificate and private key.  For reference, a
 * PKCS12 keystore can be created using the 'openssl' utility:
 *
 * openssl pkcs12 -export -in (file_containing_your_client_certificate) -inkey (file_containing_your_private_key)
 *     -out (desired_keystore_filename.p12)
 *
 * The keystore file, keystore password, and keystore type can be configured one of two ways:
 * 1. System properties
 *       -Djavax.net.ssl.keyStore=$your_keystore_filename
 *       -Djavax.net.ssl.keyStorePassword=$your_keystore_password
 *       -Djavax.net.ssl.keyStoreType=$your_keystore_type
 * 2. HttpClientOptions.Builder keyStoreFile(), keyStorePassword(), and keyStoreType() methods
 * NOTE:  When customizing your HttpClient with a keystore, the Builder keyStoreProvided() method must be set to 'true'.
 *
 * Usage Example: HttpClientOptions httpOptions = new HttpClientOptions.Builder().keyStoreProvided(true).build()
 * -- In this example, keyStoreProvided() is 'true', and since the Builder's keyStoreFile(),  keyStorePassword(), and
 * keyStoreType()  were not included, the code will look in the system properties for the keyStoreFile, keyStorePassword,
 * and keyStoreType.
 *
 */
public class HttpClientOptions {
    private final boolean trustAllCertificates;
    private final boolean keyStoreProvided;
    private final String keyStoreFile;
    private final String keyStoreType;
    private final String keyStorePass;

    /**
     * Check if trustAllCertificates is set.
     *
     * @return true or false
     */
    public boolean isTrustAllCertificates() {
        return trustAllCertificates;
    }

    /**
     * Check if keyStore is provided.
     *
     * @return true or false
     */
    public boolean isKeyStoreProvided() {
        return keyStoreProvided;
    }

    /**
     * Get the name of the keyStoreFile.
     *
     * @return name of keyStore file
     */
    public String getKeyStoreFile() {
        return keyStoreFile;
    }

    /**
     * Get the keyStore type.
     *
     * @return the keyStore type, i.e "PKCS12"
     */

    public String getKeyStoreType() {
        return keyStoreType;
    }

    /**
     * Get the keyStore password.
     *
     * @return keyStore password
     */
    public String getKeyStorePass() {
        return keyStorePass;
    }

    /**
     * Builder.
     */
    public static final class Builder {
        private boolean trustAllCertificates = false;
        private boolean keyStoreProvided = false;
        private String keyStoreFile = null;
        private String keyStoreType = null;
        private String keyStorePass = null;

        public Builder() {
        }

        public Builder trustAllCertificates(boolean val) {
            this.trustAllCertificates = val;
            return this;
        }

        public Builder keyStoreProvided(boolean val) {
            this.keyStoreProvided = val;
            return this;
        }

        public Builder keyStoreFile(String keyStoreFile) {
            // Name of the file including path
            this.keyStoreFile = keyStoreFile;
            return this;
        }

        public Builder keyStoreType(String keyStoreType) {
            // For example, "PKCS12"
            this.keyStoreType = keyStoreType;
            return this;
        }

        public Builder keyStorePassword(String keyStorePass) {
            this.keyStorePass = keyStorePass;
            return this;
        }

        public HttpClientOptions build() {
            return new HttpClientOptions(this);
        }
    }

    private HttpClientOptions(Builder builder) {
        this.trustAllCertificates = builder.trustAllCertificates;
        this.keyStoreProvided = builder.keyStoreProvided;
        this.keyStoreFile = builder.keyStoreFile;
        this.keyStoreType = builder.keyStoreType;
        this.keyStorePass = builder.keyStorePass;
    }

}
