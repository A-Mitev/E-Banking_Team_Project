package com.example.dao;

import java.sql.Connection;

import com.example.model.DBConnection;

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
