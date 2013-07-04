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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
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
import org.apache.http.client.ResponseHandler;
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

    static DefaultHttpClient createClient() {
        HttpParams params = new BasicHttpParams();
        params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECT_TIMEOUT);
        params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SOCKET_TIMEOUT);
        params.setParameter(CoreConnectionPNames.TCP_NODELAY, false);
        ClientConnectionManager cm = new ThreadSafeClientConnManager();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        return new DefaultHttpClient(cm, params);
    }

    static DefaultHttpClient wrapAuthClient(String url, String username, String password) throws SecurityException {
        DefaultHttpClient client = createClient();
        URI uri = URI.create(url);
        if ("https".equals(uri.getScheme())) { //$NON-NLS-1$
            client = enableSSL(client, uri.getPort());
        }
        AuthScope authScope = new AuthScope(uri.getHost(), uri.getPort());
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        client.getCredentialsProvider().setCredentials(authScope, credentials);
        return client;
    }

    public static String getStringContentByHttpget(String url) throws XtentisException {
        return commonGetRequest(url, "", String.class);
    }

    public static byte[] getByteArrayContentByHttpget(String url) throws XtentisException {
        return commonGetRequest(url, "", byte[].class);
    }

    public static InputStream getInstreamContentByHttpget(String url) throws XtentisException {
        return commonGetRequest(url, "", InputStream.class);
    }

    static <T> T commonGetRequest(String url, Class<T> t) throws XtentisException {
        return commonGetRequest(url, "", t); //$NON-NLS-1$
    }

    static <T> T commonGetRequest(String url, String message, Class<T> t) throws XtentisException {
        DefaultHttpClient client = createClient();
        HttpGet get = new HttpGet(url);
        return getResponseContent(client, get, message, t);
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
        DefaultHttpClient client = wrapAuthClient(URL, username, password);
        String errMessage = Messages.Util_21 + "%s" + Messages.Util_22 + "%s"; //$NON-NLS-1$//$NON-NLS-2$
        String content = getTextContent(client, request, errMessage);
        if (null == content) {
            throw new XtentisException("no response content"); //$NON-NLS-1$
        }
        return content;
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

    public static byte[] getResourceFile(String uri) throws XtentisException {
        HttpUriRequest request = new HttpGet(uri);
        DefaultHttpClient client = wrapAuthClient(uri, "admin", "talend"); //$NON-NLS-1$ //$NON-NLS-2$
        byte[] data = getByteArrayStreamContent(client, request, "{}"); //$NON-NLS-1$
        if (null == data) {
            throw new XtentisException("no response data"); //$NON-NLS-1$
        }
        return data;
    }

    static <T> T getResponseContent(DefaultHttpClient client, HttpUriRequest request, ResponseHandler<T> handler)
            throws Exception {
        if (null == request) {
            throw new IllegalArgumentException("null request"); //$NON-NLS-1$
        }
        if (null == client) {
            client = createClient();
        }
        return client.execute(request, handler);
    }

    @SuppressWarnings("unchecked")
    static <T> T consumeResponse(HttpResponse response, String message, Class<T> clz) throws XtentisException,
            IllegalStateException, IOException {
        HttpEntity content = response.getEntity();
        if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
            if (null != message) {
                EntityUtils.consume(content);
                throw new XtentisException(String.format(message, response.getStatusLine().getStatusCode(), response
                        .getStatusLine().getReasonPhrase()));
            }
        }
        if (null != clz && content != null && content.isStreaming()) {
            if (clz.equals(InputStream.class)) {
                return (T) content.getContent();
            }
            if (clz.equals(byte[].class)) {
                InputStream instream = content.getContent();
                try {
                    return (T) IOUtils.toByteArray(instream);
                } finally {
                    IOUtils.closeQuietly(instream);
                }
            }
            if (clz.equals(Reader.class)) {
                String charset = EntityUtils.getContentCharSet(content);
                try {
                    Charset set = Charset.forName(charset);
                    return (T) new InputStreamReader(content.getContent(), set);
                } catch (UnsupportedCharsetException e) {
                    log.error(e.getMessage());
                    return (T) new InputStreamReader(content.getContent());
                }
            }
            if (clz.equals(String.class)) {
                return (T) EntityUtils.toString(content);
            }
        }
        EntityUtils.consume(content);
        return null;
    }

    static String getTextContent(DefaultHttpClient client, HttpUriRequest request, String message) throws XtentisException {
        return getResponseContent(client, request, message, String.class);
    }

    static byte[] getByteArrayStreamContent(DefaultHttpClient client, HttpUriRequest request, String message)
            throws XtentisException {
        return getResponseContent(client, request, message, byte[].class);
    }

    static InputStream getInputStreamContent(DefaultHttpClient client, HttpUriRequest request, String message)
            throws XtentisException {
        return getResponseContent(client, request, message, InputStream.class);
    }

    static <T> T getResponseContent(DefaultHttpClient client, HttpUriRequest request, String message, Class<T> clz)
            throws XtentisException {
        if (null == request) {
            throw new IllegalArgumentException("null request"); //$NON-NLS-1$
        }
        if (null == client) {
            client = createClient();
        }
        HttpResponse response = null;
        try {
            response = client.execute(request);
            return consumeResponse(response, message, clz);
        } catch (XtentisException ex) {
            throw ex;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.abort();
            throw new XtentisException(e.getMessage(), e);
        }
    }

    public static byte[] downloadFile(String url, String userName, String password) throws IOException {
        HttpUriRequest request = new HttpGet(url);
        try {
            DefaultHttpClient client = wrapAuthClient(url, userName, password);
            byte[] data = getByteArrayStreamContent(client, request, null);
            if (null == data) {
                throw new IOException("no response content"); //$NON-NLS-1$
            }
            return data;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public static String uploadImageFile(String URL, String localFilename, String filename, String imageCatalog, String username,
            String password, HashMap<String, String> picturePathMap) throws XtentisException {
        HttpUriRequest request = createUploadRequest(URL, localFilename, filename, imageCatalog, picturePathMap);
        DefaultHttpClient client = wrapAuthClient(URL, username, password);
        String errMessage = Messages.Util_25 + "%s" + Messages.Util_26 + "%s"; //$NON-NLS-1$//$NON-NLS-2$
        String content = getTextContent(client, request, errMessage);
        if (null != content && content.contains("upload")) {//$NON-NLS-1$
            String returnValue = content.substring(content.indexOf("upload"), content.indexOf("}") - 1);//$NON-NLS-1$//$NON-NLS-2$
            if (picturePathMap != null) {
                File file = new File(localFilename);
                String fileName1 = file.getName();
                picturePathMap.put(fileName1, returnValue);
            }
            return returnValue;
        } else {
            throw new XtentisException("no response content"); //$NON-NLS-1$
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
