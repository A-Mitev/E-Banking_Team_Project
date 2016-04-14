package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exception.UserException;
import com.example.model.User;
import com.example.dao.IUserDAO;
import com.example.dao.UserDAO;

@Controller
@RequestMapping(value = "/LostPassword")
public class PasswordRecoveryController {

	private static final int MAX_INACTIVE_INTERVAL = 60;

	@RequestMapping( method = RequestMethod.GET)
	public String lostPassword(Model model) {
		User client = new User();
		model.addAttribute("ressetPassClient", client);
		return "PassResetEmailConfirmation";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String emailCheck(HttpServletRequest request, @RequestParam("email") String email, Model model)
			 {
		IUserDAO existingClient = (UserDAO) new UserDAO();
		try {
			if (existingClient.isEmailExcisting(email)) {
				System.out.println(existingClient.isEmailExcisting(email));
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
				User client = new User();
				model.addAttribute("ressetPassClient", client);
				model.addAttribute("hello", "Welcome " + " " + email);
				return "PassResetCodeConfirmation";
			} else {
				User client = new User();
				model.addAttribute("ressetPassClient", client);
				model.addAttribute("message", "This is unregistered mail!");
				return "PassResetEmailConfirmation";
			}
		} catch (UserException e) {
			return "Error";
		}
	}
}
