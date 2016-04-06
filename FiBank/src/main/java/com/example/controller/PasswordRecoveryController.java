package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.exception.UserException;
import com.example.model.User;
import com.example.model.UserDAO;

@Controller
@RequestMapping(value = "/LostPassword")
public class PasswordRecoveryController {

	@RequestMapping(method = RequestMethod.GET)
	public String lostPassword(Model model) {
		User client = new User();
		model.addAttribute("ressetPassClient", client);
		return "PassReset";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String passwordReset(@ModelAttribute User client, Model model) throws UserException {
		UserDAO existingClient = (UserDAO) new UserDAO();

		// public boolean isExistingEmail(existingClient.getAllUsers(),
		// client.getEmail()) {
		// // Iterates all the users
		// for (User user: usersList) {
		// // Checks if the user email is equal to the email parameter
		// if (user.email.equals(email)) {
		// return true;
		// }
		// }

		// samo za test, da iztriq!
		System.out.println(client.getEmail() + " " + client.getPassword());

		existingClient.updadeUserPassword(client.getEmail(), client.getPassword());

		return "PassReset";
	}
}
