package com.example.model;

import java.sql.Connection;

public abstract class AbstractDAO {
	
	private Connection con;

	public AbstractDAO() {
		System.out.println("abstr DAO");
		con = DBConnection.getInstance().getConnection();
		System.out.println(con);
	}

	public Connection getCon() {
		return con;
	}

}
