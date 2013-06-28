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

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

import com.amalto.workbench.i18n.Messages;

/**
 * created by HHB on 2013-6-27 This tool class wrap DefaultHttpClient to provide some methods for other class,for
 * example uploading,downloading,wrap ssl, and so on.
 * 
 */
public class HttpClientUtil {

    private static Log log = LogFactory.getLog(HttpClientUtil.class);

    public static DefaultHttpClient enableSSL(DefaultHttpClient client, int port) throws SecurityException {
        if (client == null) {
            throw new IllegalArgumentException();
        }

        try {
            SSLContext ctx = SSLContext.getInstance("TLS"); //$NON-NLS-1$
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = client.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", port, ssf)); //$NON-NLS-1$
            return new DefaultHttpClient(ccm, client.getParams());
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            return client;
        } catch (KeyManagementException e) {
            log.error(e.getMessage(), e);
            throw new SecurityException(Messages.HttpClientUtil_authorizationFail, e);
        }

    }

    private static final String PATTERN_URL = "[http|https]+://.+:(\\d+)/.*"; //$NON-NLS-1$

    public static int getPortFromUrl(String url) {
        if (url == null) {
            throw new IllegalArgumentException();
        }
        Matcher m = Pattern.compile(PATTERN_URL).matcher(url);
        if (m.find()) {
            String portStr = m.group(1);
            return Integer.parseInt(portStr);
        } else {
            return 80;
        }
    }

    public static DefaultHttpClient enableSSL(DefaultHttpClient client, String url) {
        int port = getPortFromUrl(url);
        return enableSSL(client, port);
    }
}
