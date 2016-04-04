package com.example.model;

import java.util.Date;

public class LogInRecord {

	private User user;
	private String ip;
	private Date date;
	
	
	public LogInRecord(User user, String ip, Date date) {
		this.user = user;
		this.ip = ip;
		this.date = date;
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
	
	
}
