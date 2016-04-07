package com.example.model;

import java.util.Date;

public class LogInRecord {

	private int id;
	private Date date;
	private User user;
	private String ip;
	
	
	
	public LogInRecord(Date date, User user, String ip) {
		setDate(date);
		setUser(user);
		setIp(ip);
		
	}
	
	public LogInRecord(Date date, User user, String ip, int id) {
		this(date, user, ip);
		this.id=id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
