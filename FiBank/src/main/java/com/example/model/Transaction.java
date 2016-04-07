package com.example.model;

import java.util.Date;

public class Transaction {
	private int id;
	private User sender;
	private User receiver;
	private String currency;
	private String ipOfSender;
	private double sum;
	private Date date;
	
	public Transaction(User sender, User receiver, String currency, String ipOfSender,double sum,  Date date) {
		setSender(sender);
		setReceiver(receiver);
		setCurrency(currency);
		setIpOfSender(ipOfSender);
		setSum(sum);
		setDate(date);
	}
	
	public Transaction(User sender, User receiver, String currency, String ipOfSender, double sum,  Date date, int id) {
		this(sender, receiver, currency, ipOfSender, sum, date);
		this.id=id;
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

	public int getId() {
		return id;
	}

}
