package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shailendra sharma
 * This class is used to get the connection to database
 */
public class DBConnection {
	static Connection connection; 
	int var = 10;
	
	/**
	 * @return connection
	 * */
	
	/* * This method uses the connection string and return the connection object
	 */
	public static Connection getConnection() {
		String connectionString = DbPropertyUtil.getPropertyString();
		String[] connectionStringSplitted = connectionString.split(" ");
		
		try {
			connection = DriverManager.getConnection(
					connectionStringSplitted[0], 
					connectionStringSplitted[1], 
					connectionStringSplitted[2]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		}
}
