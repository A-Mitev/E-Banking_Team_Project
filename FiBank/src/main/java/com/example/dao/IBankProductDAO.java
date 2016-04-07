package com.example.dao;

import java.util.List;

import com.example.exception.BankProductException;
import com.example.model.BankProduct;

public interface IBankProductDAO {

	int addBankProduct(BankProduct product) throws BankProductException;

	void removeBankProduct(int productId) throws BankProductException;

	BankProduct getBankProductById(int productId) throws BankProductException;

	List<BankProduct> getAllBankProducts() throws BankProductException;

}