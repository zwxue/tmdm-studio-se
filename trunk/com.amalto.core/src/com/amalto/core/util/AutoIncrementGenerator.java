package com.amalto.core.util;

import java.util.Properties;

import com.amalto.core.objects.configurationinfo.util.XtentisConfiguration;

/**
 * AutoIncrement to generate a num
 * @author achen
 *
 */
public class AutoIncrementGenerator {
	static volatile long  num=-1;
	static final String AUTO_INCREMENT_NUM="auto_increment_num";
	static Properties p= XtentisConfiguration.getConfiguration();	
	
	/**
	 * this is not a good alogrithm, need to find a better way
	 * @return
	 */
	public synchronized static long  generateNum(){
		if(num == -1){//read from configure file			
			String n=p.getProperty(AUTO_INCREMENT_NUM);
			if(n==null){
				num=0;				
			}else{
				num=Long.valueOf(n).longValue();
			}
			if(num==-1) num++;
		}else{
			++num;
		}
		
		p.setProperty(AUTO_INCREMENT_NUM, String.valueOf(num));		
		XtentisConfiguration.save();
		return num;
	}
}
