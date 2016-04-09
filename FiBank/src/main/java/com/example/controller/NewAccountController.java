package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewAccountController {

	@RequestMapping(method = RequestMethod.GET, value="/NewAccount")
	public String logout(HttpServletRequest request) {
		return "NewAccount";
	}	
}
