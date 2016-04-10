package com.example.dao;

import java.sql.Connection;

import com.example.model.DBConnection;

public abstract class AbstractDAO {
	
	private Connection con;

	public AbstractDAO() {
		con = DBConnection.getInstance().getConnection();
		System.out.println(con);
	}

	public Connection getCon() {
		return con;
	}

}
