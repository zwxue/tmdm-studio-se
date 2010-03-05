// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.engines.client.proxy;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.MultipartPostMethod;

/**
 * DOC achen class global comment. Detailled comment
 */
public class ProxyUtil {

    /*********************************************************************
     * FILE UPLOAD
     * 
     * Multi-Part Form Post
     *********************************************************************/
    public static String uploadFileToAppServer(String URL, String localFilename, String username, String password)
            throws Exception {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        /*
         * System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");
         * System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.header", "debug");
         * System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.content", "debug");
         */

        HttpClient client = new HttpClient();
        MultipartPostMethod mppost = new MultipartPostMethod(URL);
        String response = null;
        String fileName = localFilename;
        try {

            client.setConnectionTimeout(60000);
            client.getState().setAuthenticationPreemptive(true);
            client.getState().setCredentials(null, null, new UsernamePasswordCredentials(username, password));
            // if delete a job, mppost will not addParameter, otherwise there is an exception.
            if (URL.indexOf("deletefile") == -1) {
                if (URL.indexOf("deployjob") != -1) {
                    fileName = URL.substring(URL.indexOf("=") + 1);
                }
                mppost.addParameter(fileName, new File(localFilename));
            }
            // mppost.addParameter(info.getJobname()+"_"+info.getJobversion()+".war",new File(localFilename));

            client.executeMethod(mppost);
            if (mppost.getStatusCode() != HttpStatus.SC_OK) {
                throw new Exception("Server sent error: " + mppost.getStatusCode() + ": " + mppost.getStatusText());
            }
            response = mppost.getResponseBodyAsString();
            mppost.releaseConnection();
            return response;
        } catch (Exception e) {
            mppost.releaseConnection();
            e.printStackTrace();
            throw new Exception(e.getClass().getName() + ": " + e.getLocalizedMessage());
        }
    }

}
