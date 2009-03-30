package com.amalto.workbench.testdata;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.MultipartPostMethod;

import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.JobStatusType;
import com.amalto.workbench.webservices.WSDataClusterPK;
import com.amalto.workbench.webservices.WSDocument;
import com.amalto.workbench.webservices.WSGetJob;
import com.amalto.workbench.webservices.WSInboundAdaptorPK;
import com.amalto.workbench.webservices.WSJob;
import com.amalto.workbench.webservices.WSJobPK;
import com.amalto.workbench.webservices.WSPutDocument2AsJob;

public class Test extends TestCase {

	static String _server_ = "62.39.76.131";
	//static String _server_ = "localhost:8080";
	static String endpoint_address = "http://"+_server_+"/xtentis/XtentisPort";
	static String uploadURL = "http://"+_server_+"/zz.30.xtentis.MDM.servlets/uploadFile";
	static String username = "admin";
	static String password = "xtentis";
	
	static String _PKG_DATA_ = "/home/bgrieder/workspace/com.amalto.workbench/test_data/";
	
	
	public void testUploadHQCountryCodes()  throws Exception{

		System.out.print("Starting Upload of data to the Xtentis MDM server: ...");
		String filename = uploadFileToAppServer(uploadURL, _PKG_DATA_+"COUNTRIES_ISO&HQ.xml");
		System.out.println("OK");
		
		WSJobPK jobpk = Util.getPort(new URL(endpoint_address),username,password).putDocument2AsJob(
				new WSPutDocument2AsJob(
						new WSDocument(
							"COUNTRIES - CROSSREF HQ CODES",
							"Upload of Country crossreferencing data with HQ Codes",
							new WSInboundAdaptorPK("COUNTRIES - ADD HQ SYSTEM CROSSREFS"),
							false, //no cache
							null, //Cache DataCluster - null will default to CACHE
							new WSDataClusterPK[] {new WSDataClusterPK("STAGING")}, //auto add
							new WSDataClusterPK[] {new WSDataClusterPK("STAGING")}, //auto update
							null,
							null
						),
						false, //isDelete
						filename,
						"utf-8",
						"./crossref/HQ",
						new String[] {"."}
				)
		);
		WSJob job = null;
		do {
			job =  Util.getPort(new URL(endpoint_address),username,password).getJob(new WSGetJob(jobpk.getPk()));
			System.out.println(job.getMessage());
			Thread.sleep(5000);
		} while (
				job.getStatus().equals(JobStatusType.RUNNING) 
				|| job.getStatus().equals(JobStatusType.SCHEDULED)
				);
		
		System.out.println("DONE");
		
	}
	
	
	
	/*********************************************************************
	 *      FILE UPLOAD
	 *********************************************************************/
	   public static String uploadFileToAppServer(String URL, String localFilename)  throws XtentisException{
	        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
	        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
	        /*
	        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");
	        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.header", "debug");
	        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.content", "debug");
	        */
	    	
	        HttpClient client = new HttpClient();
	        client.setConnectionTimeout(60000);
	        MultipartPostMethod mppost = new MultipartPostMethod(URL);
	        String response = null;

	        //System.out.println("LOCAL FILE: "+localFilename);
	        
	        try {
	            mppost.addParameter(localFilename,new File(localFilename));
	            client.executeMethod(mppost);
	            if (mppost.getStatusCode() != HttpStatus.SC_OK) {
	            	throw new XtentisException("Server sent error: "+mppost.getStatusCode()+": "+mppost.getStatusText()); 
	            }
	            response = mppost.getResponseBodyAsString();
	            mppost.releaseConnection();
	            return response;
	        } catch (Exception e) {
	            mppost.releaseConnection();        	
	        	e.printStackTrace();
	        	throw new XtentisException(e.getClass().getName()+": "+e.getLocalizedMessage());
	        }
	    }



	/**
	 * @param arg0
	 */
	public Test(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
