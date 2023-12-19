package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * @author shailendra sharma
 * This class is used to get the connection string
 */
public class DbPropertyUtil {
	/**
	 * This method returns the connection string.

	 * @return connection string
	 */
	public static String  getPropertyString() {
		Properties props = new Properties();
		FileInputStream fis = null;
		String fileName = "db.properties";
		
		String url = null;
		String userName = null;
		String password = null;
		
		try {
			fis = new FileInputStream(fileName);
			props.load(fis);
			
			url = props.getProperty("db.url");
			userName = props.getProperty("db.username");
			password = props.getProperty("db.password");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return url + " " + userName + " " + password;
	}
}