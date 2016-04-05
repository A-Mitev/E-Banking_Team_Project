package com.example.model;

import java.util.List;

import com.example.exception.UserException;

public interface IUserDAO {

	String addUser(User user) throws UserException;

	void removeUser(String userId) throws UserException;

	User getUserById(String userId) throws UserException;

	boolean isUserExcisting(String email, String password) throws UserException;

	List<User> getAllUsers() throws UserException;

	String updadeUserPassword(String email, String newPassword) throws UserException;

}