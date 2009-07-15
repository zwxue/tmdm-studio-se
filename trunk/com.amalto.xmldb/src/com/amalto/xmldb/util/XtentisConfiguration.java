package com.amalto.xmldb.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * Handles the mdm.conf file
 * @author bgrieder
 *
 */
public final class XtentisConfiguration {

	private static Properties CONFIGURATION = null;
	
	protected XtentisConfiguration() {}
	
	public final static Properties getConfiguration(){
		return getConfiguration(false);
	}
	public final static Properties getConfiguration(boolean reload){
		if (reload) CONFIGURATION = null;
		if (CONFIGURATION != null) return CONFIGURATION;
		
		CONFIGURATION = new Properties();
		
		//first try Current path
		File file = new File("mdm.conf");
		
		if (file.exists()) {
			try {
				CONFIGURATION.load(new FileInputStream(file));
				org.apache.log4j.Logger.getLogger(XtentisConfiguration.class).info("MDM Configuration: loaded configuration in '"+file.getAbsolutePath()+"'");
			} catch (Exception e) {
				String err = "MDM Configuration: unable to load the configuration in '"+file.getAbsolutePath()+"' :"+e.getMessage()+". The default configurations will be used."; 
				org.apache.log4j.Logger.getLogger(XtentisConfiguration.class).error(err,e);
			}
		} else {
			org.apache.log4j.Logger.getLogger(XtentisConfiguration.class).info("MDM Configuration: no mdm.conf file found. Using the default configurations");
		}
		
		return CONFIGURATION;
		
	}
	

}
