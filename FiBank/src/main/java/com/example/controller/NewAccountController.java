package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.BankProductDAO;
import com.example.dao.CurrencyDAO;
import com.example.dao.IBankProductDAO;
import com.example.dao.ICurrencyDAO;
import com.example.exception.BankProductException;
import com.example.exception.CurrencyException;
import com.example.model.BankProduct;
import com.example.model.CombinedNewAccountCommand;
import com.example.model.Currency;

@Controller
public class NewAccountController {

	@RequestMapping(method = RequestMethod.GET, value="/NewAccount")
	public String newAccount(Model model) throws BankProductException, CurrencyException {
		
		IBankProductDAO bankProductDAO=new BankProductDAO();
		List<BankProduct> tmpBankProductsList=bankProductDAO.getAllBankProducts();
		List<String> bankProductDescriprion=new ArrayList<String>();
		for(int i=0; i<tmpBankProductsList.size(); i++){
			bankProductDescriprion.add((tmpBankProductsList.get(i)).toString());
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
	
		
	
	
}

