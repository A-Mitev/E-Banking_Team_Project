package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.AccountDAO;
import com.example.exception.AccountException;
import com.example.exception.BankProductException;
import com.example.exception.UserException;
import com.example.model.User;

@Controller
@RequestMapping(value = "/accounts")

public class AfterLoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCustomerAccounts(HttpSession session, Model model)
			throws AccountException, UserException, BankProductException {
		if(session.getAttribute("id") == null){
			model.addAttribute("text", "Hello, please login!");
			session.invalidate();
			return "index";
		}

		AccountDAO accounts = new AccountDAO();
		List acc = accounts.getAllAccounts();
		model.addAttribute("name", "Hello  " + session.getAttribute("name"));
		model.addAttribute("user", "Your id is " + session.getAttribute("id") );
		return "Accounts";

	}
	
}
