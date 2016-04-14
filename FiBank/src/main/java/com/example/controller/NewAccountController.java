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
import com.example.dao.IUserDAO;
import com.example.dao.UserDAO;
import com.example.exception.AccountException;
import com.example.exception.BankProductException;
import com.example.exception.CurrencyException;
import com.example.exception.UserException;
import com.example.model.Account;
import com.example.model.BankProduct;
import com.example.model.CombinedNewAccountCommand;
import com.example.model.Currency;
import com.example.model.User;

@Controller
@RequestMapping(value="/NewAccount")
public class NewAccountController {

	private static int numb=1;

	@RequestMapping(method = RequestMethod.GET)
	public String newAccount(Model model) throws BankProductException, CurrencyException {
		
		IBankProductDAO bankProductDAO=new BankProductDAO();
		List<BankProduct> tmpBankProductsList=bankProductDAO.getAllBankProducts();
		List<String> bankProductDescriprion=new ArrayList<String>();
		for(int i=0; i<tmpBankProductsList.size(); i++){
			BankProduct tmp=tmpBankProductsList.get(i);
			if(!bankProductDescriprion.contains(tmp.toString())){
			bankProductDescriprion.add(tmp.toString());
			}
		}
		
		ICurrencyDAO currencyDAO=new CurrencyDAO();
		List<Currency> tmpCurrencyList=currencyDAO.getAllCurrencies();
		List<String> currency=new ArrayList<String>();
		for(int i=0; i<tmpCurrencyList.size(); i++){
			currency.add(tmpCurrencyList.get(i).getName());
		}
		CombinedNewAccountCommand combined=new CombinedNewAccountCommand();
		model.addAttribute("combined", combined);
		model.addAttribute("text", "Adding new account: ");
		model.addAttribute("bankProducts", bankProductDescriprion);
		model.addAttribute("currency", currency);
		
		return "NewAccount";
	}	
	
	 @RequestMapping(method = RequestMethod.POST)
	    public String saveNewAccount(@ModelAttribute("combined") @Valid CombinedNewAccountCommand combined,BindingResult bindingResult, Model model, HttpServletRequest session)  {
		 try{
		 if (bindingResult.hasErrors()) {
	            return newAccount(model);
	        }
	        IBankProductDAO bankProductDAO=new BankProductDAO();
			List<BankProduct> tmpBankProductsList=bankProductDAO.getAllBankProducts();
			int index=-1;
			BankProduct tmp=null;
			for(int i=0; i<tmpBankProductsList.size(); i++){
				BankProduct bankPr=tmpBankProductsList.get(i);
				if((bankPr.toString()).toString().equals(combined.getDescription())){
					index=bankPr.getId();
					tmp=bankPr;
					break;
				}
			}
			if(index==-1){
				model.addAttribute("isntAvailable", "Sorry, this bank product isn't available anymore!");
				return newAccount(model);
			}
			if(bankProductDAO.getBankProductById(index).getMinSum()>(int)combined.getSum()){
				model.addAttribute("gteaterThan", "The initial sum must be equal or greater than the minimal sum for the product!");
				return newAccount(model);
			}
			//User user=(User)(session.getSession(false).getAttribute("user"));
			IUserDAO usDAO=new UserDAO();
			User user=usDAO.getUserById("123456789");
			numb++;
			Integer tmpNumb=new Integer(numb);
            
		    Account acc=new Account(tmpNumb.toString(), (double)((int)(combined.getSum())), combined.getCurrency(),
					    user,new Date(Calendar.getInstance().getTime().getTime()), tmp);
		    IAccountDAO accountDAO=new AccountDAO();
			accountDAO.addAccount(acc);
			model.addAttribute("newAccount","You've openned a new account!");
			return newAccount(model);
		 }
		 catch(Exception e){
			 return "Error";
		 }
			
	        
	    }	
	
	
}

