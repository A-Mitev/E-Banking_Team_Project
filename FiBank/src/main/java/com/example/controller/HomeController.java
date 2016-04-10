package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, value="/Home")
	public String sayHello(Model model, HttpServletRequest request) {
//		if(request.getSession(false)==null){
//		return "index";
//	}	
	return "Home";
}
}

	