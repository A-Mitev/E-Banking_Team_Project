package com.example.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class BankProduct {
	private String name;
	private double interest;
	private double minSum;
	private int periodInMonths;
	
	public BankProduct(String name, double interest, double minSum, int periodInMonths) {
		setName(name);
		setInterest(interest);
		setMinSum(minSum);
		setPeriodInMonths(periodInMonths);
	}

	@NotNull(message = "The name of the product is compulsory!")
	@NotBlank(message = "The name of the product is compulsory!")
	@Size(min = 2, max = 45, message = "The name of the product should have between 2 and 45 characters!") 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull @Min(1) @Max(30)
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@NotNull
	public double getMinSum() {
		return minSum;
	}

	public void setMinSum(double minSum) {
		this.minSum = minSum;
	}

	@NotNull @Min(1) @Max(240)
	public int getPeriodInMonths() {
		return periodInMonths;
	}

	public void setPeriodInMonths(int periodInMonths) {
		this.periodInMonths = periodInMonths;
	}
	
	

}
