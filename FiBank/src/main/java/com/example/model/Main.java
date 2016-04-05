package com.example.model;

import com.example.exception.UserException;

public class Main {

	public static void main(String[] args) throws UserException {
		
				IUserDAO userDao = new UserDAO();
				userDao.addUser(new User("123456789", "testName", "testAddress", "1234567890","test@email.bg", "test", TypesOfUsers.BUSINESS));
				
				


	}

}
