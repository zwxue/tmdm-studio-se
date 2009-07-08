package com.amalto.webapp.core.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;


/**
 * Handles the xtentis.conf file
 * @author bgrieder
 *
 */
public final class XtentisConfiguration {
	static File file = new File("xtentis.conf");
	static{
		
	}
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
		
		if (file.exists()) {
			try {
				CONFIGURATION.load(new FileInputStream(file));
				org.apache.log4j.Logger.getLogger(XtentisConfiguration.class).info("XTENTIS Configuration: loaded configuration in '"+file.getAbsolutePath()+"'");
			} catch (Exception e) {
				String err = "XTENTIS Configuration: unable to load the configuration in '"+file.getAbsolutePath()+"' :"+e.getMessage()+". The default configurations will be used."; 
				org.apache.log4j.Logger.getLogger(XtentisConfiguration.class).error(err,e);
			}
		} else {
			org.apache.log4j.Logger.getLogger(XtentisConfiguration.class).info("XTENTIS Configuration: no xtentis.conf file found. Using the default configurations");
		}
		
		return CONFIGURATION;
		
	}
	
	/**
	 * save configure file
	 */
	public static void save(){
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			CONFIGURATION.store(out, "mdm configure file");
		} catch (Exception e) {
			String err = "XTENTIS Configuration: unable to save the configuration in '"+file.getAbsolutePath()+"' :"+e.getMessage(); 
			org.apache.log4j.Logger.getLogger(XtentisConfiguration.class).error(err,e);
		}
		
	}

}
