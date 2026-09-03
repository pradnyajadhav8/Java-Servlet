package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	

	private final static String URL = "jdbc:mysql://localhost:3306/jap89_db01";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Pradnya@01";

	private DBUtility() {

	}

	public static Connection getDBConnection() {
		Connection con = null;
		try {
			// step 1: Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Create Connection
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print(e);
		}
		return con;
	}
	
}
