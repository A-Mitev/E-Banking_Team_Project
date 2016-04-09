package com.example.model;

public class Currency {

	private String name;
	private double fixing;
	private double buying;
	private double selling;
	
	
	public Currency(String name, double fixing) {
		this.name = name;
		this.fixing=fixing;
		setBuying();
		setSelling();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFixing() {
		return fixing;
	}
	public void setFixing(double fixing) {
		this.fixing = fixing;
	}
	public double getBuying() {
		return buying;
	}
	private void setBuying() {
		this.buying=0.95*fixing;
	}
	public double getSelling() {
		return selling;
	}
	private void setSelling() {
		this.buying=1.05*fixing;
	}
	
	
}
