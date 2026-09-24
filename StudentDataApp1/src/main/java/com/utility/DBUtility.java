package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	

	private final static String URL = "jdbc:mysql://localhost:3308/jap89_db01";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Pradnya@01";

	private static DBUtility instance=null;
	
	private DBUtility() {
		try {
			// step 1: Load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBUtility getInstance() {
		if(instance!=null) {
			return instance;
		}
		else {
			instance=new DBUtility();
			return instance;
		}
	}
	public Connection getDBConnection() {
		Connection con=null;
		try {
			// Step 2: Create Connection
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print(e);
		}
		return con;
	}
	
}
