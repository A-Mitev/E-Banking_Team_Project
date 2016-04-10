package com.example.model;

import java.sql.Date;

public class Transaction {
	private int id;
	private String ibanSender;
	private String ibanReceiver;
	private String currency;
	private String ipOfSender;
	private double sum;
	private Date date;
	
	public Transaction() {
		
	}
	
	public Transaction(String ibanSender, String ibanReceiver, String currency, String ipOfSender,double sum,  Date date) {
		setIbanSender(ibanSender);
		setIbanReceiver(ibanReceiver);
		setCurrency(currency);
		setIpOfSender(ipOfSender);
		setSum(sum);
		setDate(date);
	}
	
	public Transaction(String ibanSender, String ibanReceiver, String currency, String ipOfSender,double sum,  Date date, int id) {
		this(ibanSender, ibanReceiver, currency, ipOfSender, sum, date);
		this.id=id;
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

	public String getIbanSender() {
		return ibanSender;
	}

	public void setIbanSender(String ibanSender) {
		this.ibanSender = ibanSender;
	}

	public String getIbanReceiver() {
		return ibanReceiver;
	}

	public void setIbanReceiver(String ibanReceiver) {
		this.ibanReceiver = ibanReceiver;
	}

}
