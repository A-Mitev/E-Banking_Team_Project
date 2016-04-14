package com.example.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.IUserDAO;
import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.model.User;

@Controller
@RequestMapping(value = "/Reg")
public class RegisterController {

	@RequestMapping(method = RequestMethod.GET)
	public String clientRegister(Model model) {
		User client = new User();
		model.addAttribute("user", client);
		return "Register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addClient(User client, @ModelAttribute("user") @Valid User user, BindingResult bindingResult,
			Model model){
		if (bindingResult.hasErrors()) {

			return "Register";
		}
		if (client.getId().length() == 9) {
			client.setType("Business");
		} else {
			client.setType("Private");
		}

		long code = client.getEmail().hashCode() + (client.getEmail().hashCode() * (int) (Math.random() * 99));
		if (code < 0) {
			code *= -1;
		}
		String password;
		try {
			password = User.hashPasswordWithMD5(client.getPassword());
		} catch (Exception e) {
			return "Error";
		}
		client.setPassword(password);
		IUserDAO newClient = new UserDAO();
		try {
			newClient.addUser(client);
		} catch (UserException e) {
			return "Error";
		}
		model.addAttribute("text", "Registration was successful!" + "\n" + "Please log in!");
		return "index";
	}

}
