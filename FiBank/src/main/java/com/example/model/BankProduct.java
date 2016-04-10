package com.example.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class BankProduct {
	
	private int id;
	
	@NotNull(message = "The name of the product is compulsory!")
	@NotBlank(message = "The name of the product is compulsory!")
	@Size(min = 2, max = 45, message = "The name of the product should have between 2 and 45 characters!") 
	private String name;
	
	@NotNull(message = "The interest is compulsory!")
	@NotBlank(message = "The interest is compulsory!")
	@Min(1) @Max(30)
	private double interest;
	
	@NotNull(message = "The minimal sum is compulsory!")
	@NotBlank(message = "The minimal sum is compulsory!")
	private double minSum;
	
	@NotNull(message = "The period is compulsory!")
	@NotBlank(message = "The period is compulsory!")
	@Min(1) @Max(240)
	private int periodInMonths;
	
	public BankProduct(String name, double interest, double minSum, int periodInMonths) {
		setName(name);
		setInterest(interest);
		setMinSum(minSum);
		setPeriodInMonths(periodInMonths);
	}

	public BankProduct(String name, double interest, double minSum, int periodInMonths, int id) {
		this(name, interest, minSum, periodInMonths);
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getMinSum() {
		return minSum;
	}

	public void setMinSum(double minSum) {
		this.minSum = minSum;
	}

	public int getPeriodInMonths() {
		return periodInMonths;
	}

	public void setPeriodInMonths(int periodInMonths) {
		this.periodInMonths = periodInMonths;
	}
	
	public int getId(){
		return id;
	}

	@Override
	public String toString() {
		return "BankProduct: type=" + name + ", interest=" + interest + "% , minimal sum=" + minSum + ", period="
				+ periodInMonths + " months";
	}

}
