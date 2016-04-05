package com.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.example.exception.UserException;

public class UserDAO extends AbstractDAO{
	private static final String SELECT_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
	private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD_QUERY = "SELECT * FROM users WHERE username = ? AND password=?";
	private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";
	private static final String ADD_USER_QUERY = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public String addUser(User user) throws UserException {
		if (user != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(ADD_USER_QUERY);
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getAddress());
				ps.setString(4, user.getPhone());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getUsername());
				ps.setString(7, user.getPassword());
				ps.setString(8, user.getTypeOfUser().toString());
				
				ps.executeUpdate();

				return user.getId();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new UserException("Can't add an user with ID : "+user.getId(), e);
			}
		}
		return null;
	}

	public void removeUser(String userId) throws UserException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_USER_QUERY);
			ps.setString(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Can't delete an user with ID : " + userId, e);
		}
	}

	public User getUserById(String userId) throws UserException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_USER_BY_ID_QUERY);
			ps.setString(1, userId);
			ResultSet result = ps.executeQuery();
			result.next();
			String id = result.getString(1);
			String name = result.getString(2);
			String address = result.getString(3);
			String phone = result.getString(4);
			String  email= result.getString(5);
			String username = result.getString(6);
			String  password= result.getString(7);
			TypesOfUsers typeOfUser = TypesOfUsers.valueOf(result.getString(8));	
			
			return new User(id, name, address, phone, email, username, password, typeOfUser);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Can't find an user with ID : " + userId, e);
		}
	}
	
	public boolean isUserExcisting(String username, String password) throws UserException{
		if(username==null || password==null){
			return false;
		}
		try{
		PreparedStatement ps = getCon().prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD_QUERY);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet result = ps.executeQuery();
		return result.next();
	
	}
		catch(SQLException e){
			e.printStackTrace();
			throw new UserException("Can't find out if a user with USERNAME : "+username+
					" and a PASSWORD : "+password+" is existing!");
		}
	}
}


