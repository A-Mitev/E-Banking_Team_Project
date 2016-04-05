package com.example.model;

import java.sql.Connection;

public abstract class AbstractDAO {
	
	private Connection con;

	public AbstractDAO() {
		con = DBConnection.getInstance().getConnection();
	}

	public Connection getCon() {
		return con;
	}

}
