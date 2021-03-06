package com.example.dao;

import java.util.List;

import com.example.exception.UserException;
import com.example.model.User;

public interface IUserDAO {

	String addUser(User user) throws UserException;

	void removeUser(String userId) throws UserException;

	User getUserById(String userId) throws UserException;

	User isUserExcisting(String email, String password) throws UserException;

	List<User> getAllUsers() throws UserException;

	String updadeUserPassword(String email, String newPassword) throws UserException;
	
    boolean isEmailExcisting(String email) throws UserException;

	boolean emailConfirmationCodeMatch(String email, String code) throws UserException;

}