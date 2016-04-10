package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String DB_PASSWORD = "emag";
	private static final String DB_USER = "root";
	private static final String DATABASE = "internet_banking?useSSL=false";
	private static final String DB_PORT = "3306"; 
	private static final String DB_HOST = "127.0.0.1";
	private static final String DB_URL = DB_HOST + ":" + DB_PORT;

	private static DBConnection connectionInstance = null;
	private static Connection connection = null;


	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection
					("jdbc:mysql://" + DB_URL + "/" + DATABASE, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public static DBConnection getInstance() {
		synchronized (DBConnection.class) {
			if (connectionInstance == null) {
				connectionInstance = new DBConnection();
			}
		}

		return connectionInstance;
	}

}
