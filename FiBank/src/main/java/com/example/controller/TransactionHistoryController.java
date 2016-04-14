package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.dao.ITransactionDAO;
import com.example.dao.IUserDAO;
import com.example.dao.TransactionDAO;
import com.example.dao.UserDAO;
import com.example.exception.AccountException;
import com.example.exception.BankProductException;
import com.example.exception.CurrencyException;
import com.example.exception.TransactionException;
import com.example.exception.UserException;
import com.example.model.Transaction;
import com.example.model.User;

@Controller
public class TransactionHistoryController {
	@RequestMapping(method = RequestMethod.GET, value="/TransactionHistory")
	public String transactionHistory(Model model,HttpServletRequest session) {
		IUserDAO dao=new UserDAO();
		User user;
		
			try {
				user = dao.getUserById("123456789");
			} catch (UserException e) {
				return "Error";
			}
		
		ITransactionDAO trDAO=new TransactionDAO();
		List<Transaction> transactions=new ArrayList<Transaction>();;
		
			try {
				transactions = trDAO.getTransactionsByUser(user.getId());
			} catch (TransactionException e) {
				return "Error";
			} catch (UserException e) {
				return "Error";
			}
			model.addAttribute("transactions", transactions);

			return "TransactionHistory";
		
		

}}
