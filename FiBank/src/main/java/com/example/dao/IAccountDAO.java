package com.example.dao;

import java.util.List;

import com.example.exception.AccountException;
import com.example.exception.BankProductException;
import com.example.exception.UserException;
import com.example.model.Account;

public interface IAccountDAO {

	String addAccount(Account acc) throws AccountException;

	void removeAccount(String iban) throws AccountException;

	Account getAccountByIBAN(String accIban) throws AccountException, UserException, BankProductException;

	List<Account> getAllAccounts() throws AccountException, UserException, BankProductException;

	List<Account> getAllAccountsOfUserWithId(String userId) throws AccountException, BankProductException, UserException;

	String updadeBalance(String accIban, double newBalance) throws AccountException;

}