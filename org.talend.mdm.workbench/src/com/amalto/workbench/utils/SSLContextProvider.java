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
package com.amalto.workbench.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.eclipse.jface.preference.IPreferenceStore;

import com.amalto.workbench.MDMWorbenchPlugin;
import com.amalto.workbench.preferences.PreferenceConstants;

/**
 * created by changguopiao on 2013-7-10 Detailled comment
 * 
 */
public class SSLContextProvider {

    private static SSLContext context;

    private static final IPreferenceStore store = MDMWorbenchPlugin.getDefault().getPreferenceStore();

    private static final TrustManager TRUST_ALL = new X509TrustManager() {

        public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    public static synchronized SSLContext getContext() {
        if (null == context) {
            buildContext();
        }
        return context;
    }

    public static HostnameVerifier getHostnameVerifier() {
        boolean verify = store.getBoolean(PreferenceConstants.VERIFY_HOSTNAME);
        if (verify) {
            return SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
        } else {
            return SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        }
    }

    private static KeyManager[] buildKeyManagers() throws KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException, UnrecoverableKeyException {
        InputStream stream = null;
        try {
            String path = store.getString(PreferenceConstants.KEYSTORE_FILE);
            if (StringUtils.isEmpty(path) || !new File(path).exists()) {
                return null;
            }
            stream = new FileInputStream(path);
            String storePass = store.getString(PreferenceConstants.KEYSTORE_PASSWORD);

            KeyStore tks = KeyStore.getInstance(store.getString(PreferenceConstants.KEYSTORE_TYPE));
            tks.load(stream, storePass.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509"); //$NON-NLS-1$
            kmf.init(tks, storePass.toCharArray());

            return kmf.getKeyManagers();
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    private static TrustManager[] buildTrustManagers() throws KeyStoreException, NoSuchAlgorithmException, CertificateException,
            IOException, UnrecoverableKeyException {
        InputStream stream = null;
        try {
            String path = store.getString(PreferenceConstants.TRUSTSTORE_FILE);
            if (StringUtils.isEmpty(path) || !new File(path).exists()) {
                return new TrustManager[] { TRUST_ALL };
            }
            stream = new FileInputStream(path);
            String storePass = store.getString(PreferenceConstants.TRUSTSTORE_PASSWORD);

            KeyStore tks = KeyStore.getInstance(store.getString(PreferenceConstants.TRUSTSTORE_TYPE));
            tks.load(stream, storePass.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509"); //$NON-NLS-1$
            tmf.init(tks);

            return tmf.getTrustManagers();
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    public synchronized static void buildContext() {
        try {
            KeyManager[] kms = buildKeyManagers();
            TrustManager[] tms = buildTrustManagers();
            String algorithm = store.getString(PreferenceConstants.SSL_Algorithm);
            SSLContext sslcontext = SSLContext.getInstance(algorithm);
            sslcontext.init(kms, tms, null);
            context = sslcontext;
        } catch (Exception e) {
            throw new SecurityException(e.getMessage(), e);
        }
    }
}
