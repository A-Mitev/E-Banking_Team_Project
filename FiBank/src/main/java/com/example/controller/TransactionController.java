package com.example.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.AccountDAO;
import com.example.dao.BankProductDAO;
import com.example.dao.CurrencyDAO;
import com.example.dao.IAccountDAO;
import com.example.dao.IBankProductDAO;
import com.example.dao.ICurrencyDAO;
import com.example.dao.ITransactionDAO;
import com.example.dao.IUserDAO;
import com.example.dao.TransactionDAO;
import com.example.dao.UserDAO;
import com.example.exception.AccountException;
import com.example.exception.BankProductException;
import com.example.exception.CurrencyException;
import com.example.exception.TransactionException;
import com.example.exception.UserException;
import com.example.model.Account;
import com.example.model.BankProduct;
import com.example.model.CombinedNewAccountCommand;
import com.example.model.Currency;
import com.example.model.Transaction;
import com.example.model.User;

@Controller
@RequestMapping(value="/Transaction")
public class TransactionController {

	@RequestMapping(method = RequestMethod.GET)
	public String newTransaction(Model model) throws CurrencyException, AccountException, BankProductException, UserException {
		IUserDAO usDAO=new UserDAO();
		User user=usDAO.getUserById("123456789");
		IAccountDAO accDAO=new AccountDAO();
		List<Account> accountsOfUser=accDAO.getAllAccountsOfUserWithId(user.getId());
		List<String> accounts=new ArrayList<String>();
		for(int i=0; i<accountsOfUser.size(); i++){
			Account tmpAcc=accountsOfUser.get(i);
			if(!tmpAcc.getProduct().getName().equals("loan")){
				accounts.add(tmpAcc.getIban());
			}
		}
		
		Transaction transaction=new Transaction();
		model.addAttribute("transaction", transaction);
		model.addAttribute("text", "Transfer money: ");
		model.addAttribute("accounts", accounts);
		
		
		return "Transaction";

	}
	
	 @RequestMapping(method = RequestMethod.POST)
	    public String saveTransaction(@ModelAttribute("transaction") @Valid Transaction transaction,BindingResult bindingResult, Model model, HttpServletRequest request)  {
	
		 try{
		 if (bindingResult.hasErrors()) {
	            return newTransaction(model);
	        }
		 IAccountDAO accDAO=new AccountDAO();
		 Account tmpAccRec=accDAO.getAccountByIBAN(transaction.getIbanReceiver());
		 Account tmpAccSend=accDAO.getAccountByIBAN(transaction.getIbanSender());
		 
		 if(tmpAccRec==null){
			 System.out.println(1);
			 model.addAttribute("text3", "There is no such iban receiver!");
			 return newTransaction(model);
		 }
	        
		 if(tmpAccRec.getIban().equals(tmpAccSend.getIban())){
			 System.out.println(2);
			 model.addAttribute("text5", "The accounts must be differant!");
			 return newTransaction(model);
		 }
			if(transaction.getSum()<0){
				System.out.println(3);
				model.addAttribute("text4", "The sum must be equal or greater than 0!");
				return newTransaction(model);
			}
			
			if(transaction.getSum()>accDAO.getAccountByIBAN(transaction.getIbanSender()).getBalance()){
				System.out.println(4);
				model.addAttribute("text5", "The sum is greater than your account balance!");
				return newTransaction(model);
			}
			
			if(!tmpAccRec.getCurrency().equals(tmpAccSend.getCurrency())){
				model.addAttribute("text6", "The curruncies are differant!");
				return newTransaction(model);
			}
			double newRecBalance=tmpAccRec.getBalance()+transaction.getSum();
			double newSendBalance=tmpAccSend.getBalance()-transaction.getSum();
			accDAO.updadeBalance(transaction.getIbanReceiver(), newRecBalance);
			accDAO.updadeBalance(transaction.getIbanSender(), newSendBalance);
			ITransactionDAO trDAO=new TransactionDAO();
			trDAO.addTransaction(new Transaction(transaction.getIbanSender(), transaction.getIbanReceiver(), tmpAccRec.getCurrency(), request.getRemoteAddr(),
					transaction.getSum(), new Date(Calendar.getInstance().getTime().getTime())));
			model.addAttribute("text6", "The transaction is done!");
			return newTransaction(model);
		 }
		 catch(Exception e){
			 return "Error";
		 }
			
	        
	    }	
	
	 }

	
		 

	
	

