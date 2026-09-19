package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	private final static String URL = "jdbc:mysql://localhost:3306/employeedata";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Pradnya@01";

	private DBUtility() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print(e);
		}
	}

	private static DBUtility instance = null;

	public static DBUtility getInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = new DBUtility();
			return instance;
		}
	}

	public Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print(e);
		}
		return con;
	}
}
