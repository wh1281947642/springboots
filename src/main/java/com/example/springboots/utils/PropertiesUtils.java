package com.example.springboots.utils;

import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class PropertiesUtils {
	
	private Properties prop = new Properties();
	
	public PropertiesUtils() {
		String config = "/config.properties";
		InputStream in = PropertiesUtils.class.getResourceAsStream(config);
		try {
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PropertiesUtils(String filename) {
		InputStream in = PropertiesUtils.class.getResourceAsStream(filename);
		try {
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		String value = "";
		try {
			value = prop.getProperty(key);
		} catch (Exception e) {
			
		}
		return StringUtils.isBlank(value)? "" : value;
	}
}
