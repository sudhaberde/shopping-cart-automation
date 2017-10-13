package com.sudha.shoppingcart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class TestProperties {
	public static Properties OR = null;
	
	public static String getProperty(String key){
		if(OR == null){
			loadProperties();
		}
		return OR.getProperty(key);
	}
	
	public static void loadProperties() {
		String propFilePath = null;
		try {
			OR = new Properties();
			URL is = TestProperties.class.getClassLoader().getResource("OR.properties");
			File file = new File(is.toURI());
			propFilePath = file.getAbsolutePath();
			if (!file.exists()) {
				propFilePath = new File(
						TestProperties.class.getClassLoader().getResource("src/main/resources/OR.properties").toURI())
								.getAbsolutePath();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			OR.load(new FileInputStream(propFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
