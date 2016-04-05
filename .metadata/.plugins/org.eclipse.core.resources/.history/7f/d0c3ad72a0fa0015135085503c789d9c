package com.example.model;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

	@Bean
	public User user() {
		return new User("000000000", "defaultUser", "defaultAddress", "0000000000", 
				"deafault@email.bg","defaultUsername", "defaultPassword");
	}
	
	@Bean
	public BankProduct bankProduct() {
		return new BankProduct("defaultBankProductName", 5, -1000, 30);
	}
	
	@Bean
	public LogInRecord logInRecord() {
		return new LogInRecord(user(), "0.0.0.0", new Date());
	}
	
	@Bean
	public Account account() {
		return new Account("", user(), 0, "bg", new Date(),bankProduct());
	}

	@Bean
	public Transaction transaction() {
		return new Transaction(user(), user(), 0, "bg", "0.0.0.0", new Date());
	}
	
}
