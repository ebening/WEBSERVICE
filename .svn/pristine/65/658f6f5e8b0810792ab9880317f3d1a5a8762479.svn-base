package com.uadec.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtil {
	private static final Properties props = new Properties();
	private static final Logger log = Logger.getLogger(PropertyUtil.class);
	private static final String CONFIG_URL = "/uadec/configuration";
	public static final String TEMP_URL = "/uadec/temp";
	static{
//		InputStream is = PropertyUtil.class.getClassLoader().getResourceAsStream("cm.properties");
		try {
			InputStream is = new FileInputStream(new File(CONFIG_URL+"/cm.properties"));
			props.load(is);
		} catch (IOException e) {
			log.error(e);
		} 
	}
	public static String getProperty(String key){
		return props.getProperty(key);
	}
}
