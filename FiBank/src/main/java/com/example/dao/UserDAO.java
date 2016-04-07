package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.exception.UserException;
import com.example.model.TypesOfUsers;
import com.example.model.User;

public class UserDAO extends AbstractDAO implements IUserDAO{
	private static final String SELECT_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
	private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD_QUERY = "SELECT * FROM users WHERE email = ? AND password=?";
	private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";
	private static final String ADD_USER_QUERY = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, null)";
	private static final String UPDATE_PASSWORD_QUERY = "UPDATE users SET password=? WHERE email2=?";
	
	/* (non-Javadoc)
	 * @see com.example.model.IUserDAO#addUser(com.example.model.User)
	 */
	@Override
	public String addUser(User user) throws UserException {
		if (user != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(ADD_USER_QUERY);
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getAddress());
				ps.setString(4, user.getPhone());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getPassword());
				//ps.setString(7, user.getTypeOfUser().toString());
				
				ps.executeUpdate();

				return user.getId();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new UserException("Can't add an user with ID : "+user.getId(), e);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.model.IUserDAO#removeUser(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.example.model.IUserDAO#getUserById(java.lang.String)
	 */
	@Override
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
			String  password= result.getString(6);
			TypesOfUsers typeOfUser = TypesOfUsers.valueOf(result.getString(7));	
			
			return new User(id, name, address, phone, email, password, typeOfUser);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Can't find an user with ID : " + userId, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.IUserDAO#isUserExcisting(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isUserExcisting(String email, String password) throws UserException{
		if(email==null || password==null){
			System.out.println("isUserExcisting - vrushta null lse proverkata v if-a");
			return false;
		}
		
		System.out.println("Stiga li do tukaaaa");
		try{
		PreparedStatement ps = getCon().prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD_QUERY);
		ps.setString(1, email);
		ps.setString(2, password);
		System.out.println("printira li mail i pass v isUserExisting" + email+ " " + password);
		ResultSet result = ps.executeQuery();
		return result.next();
	
	}
		catch(SQLException e){
			e.printStackTrace();
			throw new UserException("Can't find out if a user with E-MAIL : "+email+
					" and a PASSWORD : "+password+" is existing!");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.IUserDAO#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() throws UserException {
		List<User> usersList = new ArrayList<User>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
		
			while (resultSet.next()) {
				User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),resultSet.getString(6),TypesOfUsers.valueOf(resultSet.getString(7)));
				usersList.add(user);
			}
			
			return usersList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("No users found!", e);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.IUserDAO#updadeUserPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public String updadeUserPassword(String email, String  newPassword) throws UserException {
		if (email != null && newPassword!=null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(UPDATE_PASSWORD_QUERY);
				ps.setString(1, email);
				ps.setString(2, newPassword);
				
				ps.executeUpdate();

				return email;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new UserException("Can't change the password of user with e-mail : "+email, e);
			}
		}
		return null;
	}
}


