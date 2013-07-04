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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

import com.amalto.workbench.i18n.Messages;

/**
 * created by HHB on 2013-6-27 This tool class wrap DefaultHttpClient to provide some methods for other class,for
 * example uploading,downloading,wrap ssl, and so on.
 * 
 */
public class HttpClientUtil {

    private static Log log = LogFactory.getLog(HttpClientUtil.class);

    private static final String STRING_CONTENT_TYPE = "text/plain"; //$NON-NLS-1$

    private static final int CONNECT_TIMEOUT = 6000000;

    private static final int SOCKET_TIMEOUT = 6000000;

    public static DefaultHttpClient createClient(String url, String username, String password) throws SecurityException {
        URI uri = URI.create(url);
        HttpParams params = new BasicHttpParams();
        params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECT_TIMEOUT);
        params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SOCKET_TIMEOUT);
        params.setParameter(CoreConnectionPNames.TCP_NODELAY, false);

        ClientConnectionManager cm = new ThreadSafeClientConnManager();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        DefaultHttpClient client = new DefaultHttpClient(cm, params);
        if ("https".equals(uri.getScheme())) { //$NON-NLS-1$
            client = enableSSL(client, uri.getPort());
        }
        AuthScope authScope = new AuthScope(uri.getHost(), uri.getPort());
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        client.getCredentialsProvider().setCredentials(authScope, credentials);
        return client;
    }

    static HttpUriRequest createUploadRequest(String URL, String localFilename, String filename, String imageCatalog,
            HashMap<String, String> picturePathMap) {
        HttpPost request = new HttpPost(URL);
        MultipartEntity entity = new MultipartEntity();
        if (!Messages.Util_24.equalsIgnoreCase(localFilename)) {
            File file = new File(localFilename);
            if (file.exists()) {
                entity.addPart("imageFile", new FileBody(file)); //$NON-NLS-1$
            }
        }
        if (imageCatalog != null) {
            entity.addPart("catalogName", StringBody.create(imageCatalog, STRING_CONTENT_TYPE, null)); //$NON-NLS-1$
        }
        if (filename != null) {
            int pos = filename.lastIndexOf('.');
            if (pos != -1) {
                filename = filename.substring(0, pos);
            }
            entity.addPart("fileName", StringBody.create(filename, STRING_CONTENT_TYPE, null)); //$NON-NLS-1$
        }
        request.setEntity(entity);
        return request;
    }

    public static String uploadFileToAppServer(String URL, String localFilename, String username, String password)
            throws XtentisException {
        HttpUriRequest request = createUploadFileToServerRequest(URL, localFilename);
        DefaultHttpClient client = createClient(URL, username, password);
        String errMessage = Messages.Util_21 + "%s" + Messages.Util_22 + "%s";
        byte[] data = getResponseEntityIfOk(client, request, errMessage);
        return new String(data);
    }

    static HttpUriRequest createUploadFileToServerRequest(String URL, final String fileName) {
        HttpPost request = new HttpPost(URL);
        String path = fileName;
        if (URL.indexOf("deletefile") == -1) {//$NON-NLS-1$
            if (URL.indexOf("deployjob") != -1) {//$NON-NLS-1$
                path = URL.substring(URL.indexOf("=") + 1);//$NON-NLS-1$
            }
            MultipartEntity entity = new MultipartEntity();
            entity.addPart(path, new FileBody(new File(fileName)));
            request.setEntity(entity);
        }
        return request;
    }

    /**
     * 
     * get the response content if status code is 200 otherwise throw exception
     * 
     * @param client
     * @param request
     * @param message the exception message if response status code is not 200
     * @return
     * @throws XtentisException
     */
    public static byte[] getResponseEntityIfOk(DefaultHttpClient client, HttpUriRequest request, String message)
            throws XtentisException {
        if (null == client || null == request) {
            throw new IllegalArgumentException("null arguments");
        }
        try {
            HttpResponse response = client.execute(request);
            HttpEntity content = response.getEntity();
            if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
                if (null != message) {
                    EntityUtils.consume(content);
                    throw new XtentisException(String.format(message, response.getStatusLine().getStatusCode(), response
                            .getStatusLine().getReasonPhrase()));
                }
            }
            if (content != null && content.isStreaming()) {
                InputStream instream = content.getContent();
                try {
                    return IOUtils.toByteArray(instream);
                } finally {
                    IOUtils.closeQuietly(instream);
                }
            }
            return null;
        } catch (XtentisException ex) {
            throw ex;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.abort();
            throw new XtentisException(e.getClass().getName() + ": " + e.getLocalizedMessage());
        }
    }

    public static byte[] downloadFile(String url, String userName, String password) throws IOException {
        HttpUriRequest request = new HttpGet(url);
        try {
            DefaultHttpClient client = createClient(url, userName, password);
            return getResponseEntityIfOk(client, request, null);
        } catch (XtentisException e) {
            throw new IOException(e);
        }
    }

    public static String uploadImageFile(String URL, String localFilename, String filename, String imageCatalog, String username,
            String password, HashMap<String, String> picturePathMap) throws XtentisException {
        HttpUriRequest request = createUploadRequest(URL, localFilename, filename, imageCatalog, picturePathMap);
        DefaultHttpClient client = createClient(URL, username, password);
        String errMessage = Messages.Util_25 + "%s" + Messages.Util_26 + "%s";
        byte[] data = getResponseEntityIfOk(client, request, errMessage);
        String content = new String(data);
        if (content.contains("upload")) {//$NON-NLS-1$
            String returnValue = content.substring(content.indexOf("upload"), content.indexOf("}") - 1);//$NON-NLS-1$//$NON-NLS-2$
            if (picturePathMap != null) {
                File file = new File(localFilename);
                String fileName1 = file.getName();
                picturePathMap.put(fileName1, returnValue);
            }
            return returnValue;
        } else {
            log.warn("no update field in response content"); //$NON-NLS-1$
            return "";//$NON-NLS-1$
        }
    }

    public static DefaultHttpClient enableSSL(DefaultHttpClient client, int port) throws SecurityException {
        if (client == null) {
            throw new IllegalArgumentException();
        }

        try {
            SSLContext ctx = SSLContext.getInstance("TLS"); //$NON-NLS-1$
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                    // FIXME
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                    // FIXME
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

    public static OutputStream downloadFile(String url, String downloadFolder) {
        try {
            URL urlFile = new URL(url);
            String filename = urlFile.getFile();
            if (filename != null) {
                int pos = filename.lastIndexOf('/');
                if (pos != -1) {
                    filename = filename.substring(pos + 1);
                }
            } else {
                int pos = url.lastIndexOf('/');
                if (pos != -1) {
                    filename = url.substring(pos + 1);
                }
            }
            InputStream input = urlFile.openStream();
            byte[] bytes = IOUtils.toByteArray(input);
            FileOutputStream output = new FileOutputStream(new File(downloadFolder + "/" + filename)); //$NON-NLS-1$
            IOUtils.write(bytes, output);
            return output;
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
