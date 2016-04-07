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
		if(session == null){
			return "index";
		}

		AccountDAO accounts = new AccountDAO();
		List acc = accounts.getAllAccounts();
		model.addAttribute("user", session.getAttribute("test") );
		return "Accounts";

	}
	
}
