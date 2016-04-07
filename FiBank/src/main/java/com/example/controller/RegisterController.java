package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.model.User;

@Controller
@RequestMapping(value="/Reg")
public class RegisterController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String clientRegister(Model model){
	User client = new User();
	model.addAttribute("user", client);
		return "Register";
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public void clientRegister1(@ModelAttribute User client) throws UserException{
		UserDAO newClient = new UserDAO();
	newClient.addUser(client);
	}	

}
