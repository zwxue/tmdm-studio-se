package com.amalto.xmldb.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * Handles the xtentis.conf file
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
		File file = new File("xtentis.conf");
		if (!file.exists()) {
			//try file in Amalto configuration path
			String os = System.getProperty("os.name");
			file = new File("/etc/amalto/xtentis/xtentis.conf");
			if (os.toLowerCase().matches(".*windows.*")) {
				file = new File("c:\\amalto\\xtentis\\xtentis.conf");
			}			
		}
		
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
	

}
