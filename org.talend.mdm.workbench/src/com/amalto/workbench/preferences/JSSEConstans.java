// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.preferences;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * created by changguopiao on 2013-7-10 Detailled comment
 * 
 */
public interface JSSEConstans {

    class TruststoreSource {

        private boolean enable = true;

        private URL source;

        private char[] password;

        private String type;

        public TruststoreSource() {
        }

        public TruststoreSource(File file, String password, String type) throws MalformedURLException {
            this(file.toURI().toURL(), password, type);
        }

        public TruststoreSource(URL url, String password, String type) {
            this.source = url;
            this.password = password.toCharArray();
            this.type = type;
        }

        /**
         * Getter for password.
         * 
         * @return the password
         */
        public char[] getPassword() {
            return this.password;
        }

        /**
         * Getter for enable.
         * 
         * @return the enable
         */
        public boolean isEnable() {
            return this.enable;
        }

        /**
         * Sets the enable.
         * 
         * @param enable the enable to set
         */
        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        /**
         * Sets the password.
         * 
         * @param password the password to set
         */
        public void setPassword(char[] password) {
            this.password = password;
        }

        /**
         * Sets the source.
         * 
         * @param source the source to set
         */
        public void setSource(URL source) {
            this.source = source;
        }

        /**
         * Sets the type.
         * 
         * @param type the type to set
         */
        public void setType(String type) {
            this.type = type;
        }

        public URL getSource() {
            return source;
        }

        public InputStream openSourceStream() throws IOException {
            return source.openStream();
        }

        public char[] getStorePassword() {
            return password;
        }

        public String getType() {
            return this.type;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            return source.hashCode();
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof TruststoreSource)) {
                return false;
            }
            TruststoreSource other = (TruststoreSource) obj;
            if (this.source == null) {
                if (other.source != null) {
                    return false;
                }
            } else if (!this.source.equals(other.source)) {
                return false;
            }
            return true;
        }

    }

    class KeystoreSource extends TruststoreSource {

        char[] mainPassword;

        public KeystoreSource(File file, String password, String mainPass, String type) throws MalformedURLException {
            super(file, password, type);
            this.mainPassword = mainPass.toCharArray();
        }

        public char[] getMainPass() {
            return mainPassword;
        }
    }

    public enum VERIFY_TYPE {
        ALLOW_ALL,
        STRICT,
        COMPATIBLE;
    }

    // http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html#CertificateFactory
    public enum CERTIFICATE_FACTORY_TYPE {
        X509;
    }

    // http://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#KeyStore
    public enum KEYSTORE_TYPE {
        JKS,
        JCEKS,
        PKCS12;
    }

    // http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html#SSLContext
    public enum SSL_Algorithm {
        SSL,
        TLS;
    }

}
