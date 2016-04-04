package com.example.model;

import java.util.Date;

public class Transaction {
	private User sender;
	private User receiver;
	private double sum;
	private String currency;
	private String ipOfSender;
	private Date date;
	
	public Transaction(User sender, User receiver, double sum, String currency,
			String ipOfSender, Date date) {
		this.sender = sender;
		this.receiver = receiver;
		this.sum = sum;
		this.currency = currency;
		this.ipOfSender = ipOfSender;
		this.setDate(date);
	}
	
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getIpOfSender() {
		return ipOfSender;
	}
	public void setIpOfSender(String ipOfSender) {
		this.ipOfSender = ipOfSender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
