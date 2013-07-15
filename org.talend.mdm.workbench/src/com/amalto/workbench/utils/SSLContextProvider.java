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

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.preference.IPreferenceStore;

import com.amalto.workbench.MDMWorbenchPlugin;
import com.amalto.workbench.preferences.JSSEConstans.KeystoreSource;
import com.amalto.workbench.preferences.JSSEConstans.TruststoreSource;
import com.amalto.workbench.preferences.PreferenceConstants;
import com.thoughtworks.xstream.XStream;

/**
 * created by changguopiao on 2013-7-10 Detailled comment
 * 
 */
public class SSLContextProvider {

    private SSLContext context;

    private static SSLContextProvider INSTANCE = new SSLContextProvider();

    private Log log = LogFactory.getLog(SSLContextProvider.class);

    private IPreferenceStore store;

    private SSLContextProvider() {
        store = MDMWorbenchPlugin.getDefault().getPreferenceStore();
        TruststoreSource[] sources = loadKeystore();
        if (null != sources) {
            for (TruststoreSource source : sources) {
                try {
                    addKeystore(source);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    public static SSLContextProvider getInstance() {
        return INSTANCE;
    }

    private static final TrustManager TRUST_ALL = new X509TrustManager() {

        public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    public SSLContext getContext() {
        createSSLContext();
        return context;
    }

    final private Map<KeystoreSource, KeyManagerFactory> kmfMap = new HashMap<KeystoreSource, KeyManagerFactory>();

    final private Map<TruststoreSource, TrustManagerFactory> tmfMap = new HashMap<TruststoreSource, TrustManagerFactory>();

    private volatile boolean isNew;

    public TruststoreSource[] getKeystores() {
        TruststoreSource[] ret = new TruststoreSource[tmfMap.size() + kmfMap.size()];
        int index = 0;
        for (TruststoreSource source : kmfMap.keySet()) {
            ret[index++] = source;
        }
        for (TruststoreSource source : tmfMap.keySet()) {
            ret[index++] = source;
        }
        return ret;
    }

    public void changeSource() {
        isNew = false;
    }

    public void removeKeystore(TruststoreSource keystore) {
        if (keystore instanceof KeystoreSource) {
            kmfMap.remove(keystore);
        } else {
            tmfMap.remove(keystore);
        }
        isNew = false;
    }

    public void addKeystore(TruststoreSource keystore) throws KeyStoreException, NoSuchAlgorithmException, IOException,
            CertificateException, UnrecoverableKeyException {
        log.debug("load key manager from " + keystore.getSource()); //$NON-NLS-1$
        String keystoreType = keystore.getType();
        InputStream keystream = null;
        try {
            KeyStore tks = KeyStore.getInstance(keystoreType);
            keystream = keystore.getSource().openStream();
            char[] pass = keystore.getStorePassword();
            tks.load(keystream, pass);
            if (keystore instanceof KeystoreSource) {
                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509"); //$NON-NLS-1$
                kmf.init(tks, ((KeystoreSource) keystore).getMainPass());
                kmfMap.put((KeystoreSource) keystore, kmf);
            } else {
                TrustManagerFactory kmf = TrustManagerFactory.getInstance("SunX509"); //$NON-NLS-1$
                kmf.init(tks);
                tmfMap.put(keystore, kmf);
            }
            isNew = false;
        } finally {
            IOUtils.closeQuietly(keystream);
        }
    }

    TruststoreSource[] loadKeystore() {
        XStream xstream = new XStream();
        String content = store.getString(PreferenceConstants.MDM_KEYSTORE);
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return (TruststoreSource[]) xstream.fromXML(content);
        } catch (Exception e) {
            return null;
        } finally {
            isNew = false;
        }
    }

    public void saveKeystore() {
        XStream xstream = new XStream();
        TruststoreSource[] sources = getKeystores();
        store.setValue(PreferenceConstants.MDM_KEYSTORE, xstream.toXML(sources));

    }

    public synchronized void createSSLContext() {
        if (isNew) {
            return;
        }
        try {
            KeyManager[] kms = null;
            List<KeyManager> kList = new ArrayList<KeyManager>(kmfMap.size());
            for (KeystoreSource source : kmfMap.keySet()) {
                if (!source.isEnable()) {
                    continue;
                }
                KeyManagerFactory kf = kmfMap.get(source);
                for (KeyManager km : kf.getKeyManagers()) {
                    kList.add(km);
                }
            }
            TrustManager[] tms = null;
            List<TrustManager> tList = new ArrayList<TrustManager>(tmfMap.size());
            for (TruststoreSource source : tmfMap.keySet()) {
                if (!source.isEnable()) {
                    continue;
                }
                TrustManagerFactory kf = tmfMap.get(source);
                for (TrustManager km : kf.getTrustManagers()) {
                    tList.add(km);
                }
            }
            if (!kList.isEmpty()) {
                kms = kList.toArray(new KeyManager[] {});
            }
            if (!tList.isEmpty()) {
                tms = tList.toArray(new TrustManager[] {});
            } else {
                tms = new TrustManager[] { TRUST_ALL };
            }
            String algorithm = store.getString(PreferenceConstants.SSL_Algorithm);
            SSLContext sslcontext = SSLContext.getInstance(algorithm);
            sslcontext.init(kms, tms, null);
            context = sslcontext;
            isNew = true;
        } catch (Exception e) {
            isNew = false;
            throw new SecurityException(e);
        }
    }
}
