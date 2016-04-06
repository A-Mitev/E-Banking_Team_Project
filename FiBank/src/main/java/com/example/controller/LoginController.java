package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exception.UserException;
import com.example.model.UserDAO;
@Controller
@RequestMapping(value="/index")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("text", "Hello, please login!");
		return "index";
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String userAuthentication(@RequestParam("email")String user,
			@RequestParam("pass") String pass, Model model) throws UserException{
		UserDAO client = new UserDAO();
		
		if((user !=null & pass != null) && (!user.equals("") && (!pass.equals(""))) && (client.isUserExcisting(user, pass)) ){
			return "Welcome";
		} else {
			model.addAttribute("text", "Username ot password - invalid."
					+ " Please check and try again!");
			return "index";
		}
	}
}
