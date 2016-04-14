package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ILogInRecordDAO;
import com.example.dao.ITransactionDAO;
import com.example.dao.IUserDAO;
import com.example.dao.LogInRecordDAO;
import com.example.dao.TransactionDAO;
import com.example.dao.UserDAO;
import com.example.exception.LogInRecordException;
import com.example.exception.TransactionException;
import com.example.exception.UserException;
import com.example.model.LogInRecord;
import com.example.model.Transaction;
import com.example.model.User;

@Controller
public class LogInHistoryController {

	@RequestMapping(method = RequestMethod.GET, value="/LogInHistory")
	public String transactionHistory(Model model,HttpServletRequest session){
		IUserDAO dao=new UserDAO();
		User user;
		try {
			user = dao.getUserById("123456789");
		} catch (UserException e1) {
			return "Error";
		}
		ILogInRecordDAO logDAO=new LogInRecordDAO();
		List<LogInRecord> logIns=new ArrayList<LogInRecord>();;
		try {
			logIns = logDAO.getLogInRecordsByUserId(user.getId());
		} catch (LogInRecordException e) {
			return "Error";
		} catch (UserException e) {
			return "Error";
		}
		model.addAttribute("logIns", logIns);
		return "TransactionHistory";

}}
