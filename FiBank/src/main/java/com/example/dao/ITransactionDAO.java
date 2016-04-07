package com.example.dao;

import java.sql.Date;
import java.util.List;

import com.example.exception.TransactionException;
import com.example.exception.UserException;
import com.example.model.Transaction;
import com.example.model.User;

public interface ITransactionDAO {

	int addTransaction(Transaction transaction) throws TransactionException;

	void removeTransactionById(int transactionId) throws TransactionException;

	void removeTransactionsForUser(User user) throws TransactionException;

	void removeTransactionsForDate(Date date) throws TransactionException;

	Transaction getTransactionById(int transactionId) throws TransactionException, UserException;

	List<Transaction> getTransactionsByUser(String userId) throws TransactionException, UserException;

	List<Transaction> getTransactionsByDate(Date date) throws TransactionException, UserException;

	List<Transaction> getAllTransactions() throws TransactionException, UserException;

}