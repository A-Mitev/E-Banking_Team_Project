package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.exception.AccountException;
import com.example.exception.BankProductException;
import com.example.exception.UserException;
import com.example.model.Account;
import com.example.model.BankProduct;
import com.example.model.User;

public class AccountDAO extends AbstractDAO implements IAccountDAO {
	private static final String SELECT_ACCOUNT_BY_IBAN_QUERY = "SELECT * FROM accounts WHERE iban = ?";
	private static final String SELECT_ACCOUNT_BY_ACCOUNT_HOLDER_QUERY = "SELECT * FROM accounts WHERE account_holder = ?";
	private static final String ADD_ACCOUNT_QUERY = "INSERT INTO accounts VALUES (?, ?, ?, ?, ?, ?)";
	private static final String DELETE_ACCOUNT_QUERY = "DELETE FROM accounts WHERE iban = ?";
	private static final String UPDATE_BALANCE_QUERY = "UPDATE accounts SET balance=? WHERE iban=?";
	
	/* (non-Javadoc)
	 * @see com.example.model.IAccountDAO#addAccount(com.example.model.Account)
	 */
	@Override
	public String addAccount(Account acc) throws AccountException {
		System.err.println(acc);
		if (acc != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(ADD_ACCOUNT_QUERY);
				ps.setString(1, acc.getIban());
				ps.setDouble(2, acc.getBalance());
				ps.setString(3, acc.getCurrency());
				ps.setString(4, acc.getAccountHolder().getId());
				ps.setDate(5, (Date) acc.getDateOfCreation());
				ps.setInt(6, acc.getProduct().getId());
				
				ps.executeUpdate();

				return acc.getIban();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AccountException("Can't add an account with IBAN : "+acc.getIban(), e);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.model.IAccountDAO#removeAccount(java.lang.String)
	 */
	@Override
	public void removeAccount(String iban) throws AccountException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_ACCOUNT_QUERY);
			ps.setString(1, iban);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountException("Can't delete an account with IBAN : " + iban, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.IAccountDAO#getAccountByIBAN(java.lang.String)
	 */
	@Override
	public Account getAccountByIBAN(String accIban) throws AccountException, UserException, BankProductException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_ACCOUNT_BY_IBAN_QUERY);
			ps.setString(1, accIban);
			ResultSet result = ps.executeQuery();
			result.next();
			String iban = result.getString(1);
			Double balance = result.getDouble(2);
			String currency = result.getString(3);
			IUserDAO userDAO=new UserDAO();
			User accountHolder=userDAO.getUserById(result.getString(4));
			Date dateOfCreation= result.getDate(5);
			IBankProductDAO productDAO=new BankProductDAO();
			BankProduct product= productDAO.getBankProductById(result.getInt(6));	
			
			return new Account(iban, balance, currency, accountHolder, dateOfCreation, product);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountException("Can't find an account with IBAN : " + accIban, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.IAccountDAO#getAllAccounts()
	 */
	@Override
	public List<Account> getAllAccounts() throws AccountException, UserException, BankProductException {
		List<Account> accountList = new ArrayList<Account>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts;");
		
			while (resultSet.next()) {
				String iban = resultSet.getString(1);
				Double balance = resultSet.getDouble(2);
				String currency = resultSet.getString(3);
				IUserDAO userDAO=new UserDAO();
				User accountHolder=userDAO.getUserById(resultSet.getString(4));
				Date dateOfCreation= resultSet.getDate(5);
				IBankProductDAO productDAO=new BankProductDAO();
				BankProduct product= productDAO.getBankProductById(resultSet.getInt(6));
				Account acc = new Account(iban, balance, currency,accountHolder, dateOfCreation, product);
				accountList.add(acc);
			}
			
			return accountList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("No accounts found!", e);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.IAccountDAO#getAllAccountsOfUserWithId(java.lang.String)
	 */
	@Override
	public List<Account> getAllAccountsOfUserWithId(String userId) throws AccountException, BankProductException, UserException {
		List<Account> accountList = new ArrayList<Account>();
		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_ACCOUNT_BY_ACCOUNT_HOLDER_QUERY);
			ps.setString(1, userId);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				String iban = result.getString(1);
				Double balance = result.getDouble(2);
				String currency = result.getString(3);
				IUserDAO userDAO=new UserDAO();
				User accountHolder=userDAO.getUserById(result.getString(4));
				Date dateOfCreation= result.getDate(5);
				IBankProductDAO productDAO=new BankProductDAO();
				BankProduct product= productDAO.getBankProductById(result.getInt(6));
				Account acc = new Account(iban, balance, currency,accountHolder, dateOfCreation, product);
				accountList.add(acc);
			}
			
			return accountList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("No accounts for user with ID : "+userId+" found!", e);
		}
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.example.model.IAccountDAO#updadeBalance(java.lang.String, double)
	 */
	@Override
	public String updadeBalance(String accIban, double newBalance) throws AccountException {
		if (accIban != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(UPDATE_BALANCE_QUERY);
				ps.setDouble(1, newBalance);
				ps.setString(2, accIban);
				
				ps.executeUpdate();

				return accIban;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AccountException("Can't change the balance of account with IBAN : "+accIban, e);
			}
		}
		return null;
	}

}
