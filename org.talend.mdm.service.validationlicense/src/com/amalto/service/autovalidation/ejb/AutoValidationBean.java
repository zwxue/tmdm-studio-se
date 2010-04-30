package com.amalto.service.autovalidation.ejb;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;


import com.amalto.core.ejb.ItemPOJOPK;
import com.amalto.core.ejb.ServiceCtrlBean;
import com.amalto.core.util.XtentisException;
import com.amalto.core.util.license.TokenGetter;
import com.amalto.webapp.core.util.license.LicenseUtil;

/**
 * @author Bruno Grieder
 * 
 * @ejb.bean 	name="AutoValidationBean"
 *           	display-name="Name for DumpToConsole"
 *           	description="Description for DumpToConsole"
 * 		  		local-jndi-name = "amalto/local/service/autovalidation"
 *           	type="Stateless"
 *           	view-type="local"
 * 
 * @ejb.remote-facade
 * 
 * @ejb.permission
 * 	view-type = "remote"
 * 	role-name = "administration"
 * @ejb.permission
 * 	view-type = "local"
 * 	unchecked = "true"
 * 
 * 
 * 
 */
public class AutoValidationBean extends ServiceCtrlBean  implements SessionBean{
  
	private static final long serialVersionUID = 290873987;

	

	/* (non-Javadoc)
	 * @see com.amalto.core.ejb.ServiceCtrlBean#getJNDIName()
	 */
    /**
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getJNDIName() throws XtentisException {
		return "amalto/local/service/autovalidation";
	}
	
    /**
     * 
     * @see com.amalto.core.ejb.ServiceCtrlBean#getConfiguration(java.lang.String)
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
    public String getConfiguration(String optionalParameters) throws XtentisException{
    	return "";
    }
	/* (non-Javadoc)
	 * @see com.amalto.core.ejb.ServiceCtrlBean#getDescription()
	 */
    /**
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getDescription(String twoLetterLanguageCode) throws XtentisException {
		if ("fr".matches(twoLetterLanguageCode.toLowerCase()))
			return "This service dumps the content of the Item to the console and logs it as INFO";
		return "This service dumps the content of the Item to the console and logs it as INFO";
	}

    /**
     * @author achen
     * @throws XtentisException
     * @ejb.interface-method view-type = "both"
     * @ejb.facade-method 
     */
    public  String getDocumentation(String twoLettersLanguageCode) throws XtentisException{
    	return "N/A";
    }
	/* (non-Javadoc)
	 * @see com.amalto.core.ejb.ServiceCtrlBean#getStatus()
	 */
    /**
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String getStatus() throws XtentisException {
		return "OK"; 
	}


	/* (non-Javadoc)
	 * @see com.amalto.core.ejb.ServiceCtrlBean#start()
	 */
    /**
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public void start() throws XtentisException {
		return;
	}


	/* (non-Javadoc)
	 * @see com.amalto.core.ejb.ServiceCtrlBean#stop()
	 */
    /**
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public void stop() throws XtentisException {
		return;
	}


	/* (non-Javadoc)
	 * @see com.amalto.core.ejb.ServiceCtrlBean#receiveFromOutbound(java.util.HashMap, java.lang.String)
	 */
    /**
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public Serializable receiveFromOutbound(HashMap<String, Serializable> map) throws XtentisException {
		return null;
	}




	/* (non-Javadoc)
	 * @see com.amalto.core.ejb.IServiceBean#run(java.lang.String)
	 */
    /**
     * @throws EJBException
     * 
     * @ejb.interface-method view-type = "local"
     * @ejb.facade-method 
     */
	public String receiveFromInbound(ItemPOJOPK itemPK, String routingOrderID, String parameters) throws XtentisException {
		return null;
	}
	
	

	private void dump(String string) {
	}
	
	/**
	 * @throws EJBException
	 *
	 * @ejb.interface-method view-type = "local"
	 * @ejb.facade-method
	 */
	 public Serializable fetchFromOutbound(String command, String parameters,String schedulePlanID) throws XtentisException {
		 try {
			 final URL url = new URL("http://www.talend.com/api/get_tis_validation_token.php?msg=");
			 String license = LicenseUtil.getInstance().getLicense();
			 String newCompany = LicenseUtil.getInstance().getCompanyName();
			 URLConnection httpURLConnection = url.openConnection();
			 httpURLConnection.setDoOutput(true);
			 OutputStreamWriter writer = new OutputStreamWriter(httpURLConnection.getOutputStream());
		
			 final String x = URLEncoder.encode(new TokenGetter().getValidationRequest(license, newCompany), "UTF8");
			 writer.write("msg=" + x);
			 writer.flush();
			 InputStream in = httpURLConnection.getInputStream();
			 BufferedReader r = new BufferedReader(new InputStreamReader(in));
			 
			 LicenseUtil.getInstance().setNewToken(r.readLine());
			 
			 return "ok";
		 }
		 catch(Exception e) {
			 String err = "ERROR: unable to set new validation token"
					+e.getClass().getName()+": "+e.getLocalizedMessage();
			 org.apache.log4j.Logger.getLogger(this.getClass()).error(err);
			 return null;
		 }
	 }

    
}