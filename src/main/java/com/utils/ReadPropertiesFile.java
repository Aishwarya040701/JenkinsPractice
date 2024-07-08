package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	Properties obj;

	public String getProperties(String key) {
		try {
			FileInputStream fi = new FileInputStream("src/test/resources/propertiesFile/SauceWebsite.properties");
			obj = new Properties();
			obj.load(fi);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return obj.getProperty(key);

	}
}
