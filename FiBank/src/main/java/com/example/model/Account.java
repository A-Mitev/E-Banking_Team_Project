package com.example.model;

import java.util.Date;

public class Account {
	private String iban;
	private double balance;
	private String currency;
	private User accountHolder;
	private Date dateOfCreation;
	private BankProduct product;
	
	
	public Account(String iban, double balance, String currency, User accountHolder,  Date dateOfCreation,
			BankProduct product) {
		setIban(iban);
		setBalance(balance);
		setCurrency(currency);
		setAccountHolder(accountHolder);
		setDateOfCreation(dateOfCreation);
		setProduct(product);
	}
	
	public String getIban() {
		return iban;
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public User getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(User accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	public BankProduct getProduct() {
		return product;
	}
	
	public void setProduct(BankProduct product) {
		this.product = product;
	}
	
	
	
}
