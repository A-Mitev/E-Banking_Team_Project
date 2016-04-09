package com.example.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class CombinedNewAccountCommand {

	@NotNull(message = "The choise of bank product is compulsory!")
	@NotBlank(message = "The choise of bank product is compulsory!")
	private String description;
	
	@NotNull(message = "The choise of currency is compulsory!")
	@NotBlank(message = "The choise of currency is compulsory!")
	private String currency;
	
	@NotNull(message = "The intial sum is compulsory!")
	@NotBlank(message = "The initial sum is compulsory!")
	@Min(0)
	@Max(50000)
	private Integer sum;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
