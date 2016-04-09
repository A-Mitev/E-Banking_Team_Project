package com.example.dao;

import java.util.List;

import com.example.exception.CurrencyException;
import com.example.model.Currency;

public interface ICurrencyDAO {

	void removeCurrency(String currency) throws CurrencyException;

	Currency getCurrency(String currency) throws CurrencyException;

	List<Currency> getAllCurrencies() throws CurrencyException;

	String updadeCurrency(String currency, double newFixing) throws CurrencyException;

}