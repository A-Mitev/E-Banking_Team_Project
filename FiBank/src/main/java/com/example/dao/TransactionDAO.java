package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.exception.TransactionException;
import com.example.exception.UserException;
import com.example.model.Transaction;
import com.example.model.User;

public class TransactionDAO extends AbstractDAO implements ITransactionDAO {
	private static final String SELECT_TRANSACTION_BY_ID_QUERY = "SELECT * FROM transactions WHERE id_transaction= ?";
	private static final String SELECT_TRANSACTIONS_BY_USER_ID_QUERY = "SELECT * FROM transactions t join accounts a ON (t.sender_iban=a.iban) join  users u on (a.account_holder=u.id) WHERE id=?";
	private static final String SELECT_TRANSACTIONS_BY_DATE_QUERY = "SELECT * FROM transactions WHERE date = ?";
	private static final String DELETE_TRANSACTION_BY_ID_QUERY = "DELETE FROM transactions WHERE id_transaction= ?";
	private static final String DELETE_TRANSACTIONS_BY_USER_QUERY = "DELETE FROM transactions WHERE sender_iban= ?";
	private static final String DELETE_TRANSACTIONS_BY_DATE_QUERY = "DELETE FROM transactions WHERE date= ?";
	private static final String ADD_TRANSACION_QUERY = "INSERT INTO transactions VALUES (null, ?,?,?,?,?,?)";

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#addTransaction(com.example.model.Transaction)
	 */
	@Override
	public int addTransaction(Transaction transaction) throws TransactionException {
		if (transaction != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(ADD_TRANSACION_QUERY,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, transaction.getIbanSender());
				ps.setString(2, transaction.getIbanReceiver());
				ps.setString(3, transaction.getCurrency());
				ps.setString(4, transaction.getIpOfSender());
				ps.setDouble(5, transaction.getSum());
				ps.setDate(6, (Date) transaction.getDate());

				ps.executeUpdate();

				ResultSet id = ps.getGeneratedKeys();
				id.next();
				return id.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new TransactionException("Can't add a transaction!", e);
			}
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#removeTransactionById(int)
	 */
	@Override
	public void removeTransactionById(int transactionId) throws TransactionException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_TRANSACTION_BY_ID_QUERY);
			ps.setInt(1, transactionId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TransactionException("Can't delete a transaction with ID : " + transactionId, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#removeTransactionsForUser(com.example.model.User)
	 */
	@Override
	public void removeTransactionsForUser(User user) throws TransactionException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_TRANSACTIONS_BY_USER_QUERY);
			ps.setString(1, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TransactionException("Can't delete  transactions for user with USER ID : " + user.getId(), e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#removeTransactionsForDate(java.sql.Date)
	 */
	@Override
	public void removeTransactionsForDate(Date date) throws TransactionException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_TRANSACTIONS_BY_DATE_QUERY);
			ps.setDate(1, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TransactionException("Can't delete a transaction for date : " + date, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#getTransactionById(int)
	 */
	@Override
	public Transaction getTransactionById(int transactionId) throws TransactionException, UserException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_TRANSACTION_BY_ID_QUERY);
			ps.setInt(1, transactionId);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			String sender = result.getString(2);
			String receiver = result.getString(3);
			String currency = result.getString(4);
			String ipOfSender = result.getString(5);
			Double sum = result.getDouble(6);
			Date date = result.getDate(7);

			return new Transaction(sender, receiver, currency, ipOfSender, sum, date, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TransactionException("Can't find a transaction with ID : " + transactionId, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#getTransactionsByUser(java.lang.String)
	 */
	@Override
	public List<Transaction> getTransactionsByUser(String userId) throws TransactionException, UserException {
		List<Transaction> transactionsList = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_TRANSACTIONS_BY_USER_ID_QUERY);
			ps.setString(1, userId);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String sender = resultSet.getString(2);
				String receiver = resultSet.getString(3);
				String currency = resultSet.getString(4);
				String ipOfSender = resultSet.getString(5);
				Double sum = resultSet.getDouble(6);
				Date date = resultSet.getDate(7);

				Transaction tmpTransaction = new Transaction(sender, receiver, currency, ipOfSender, sum, date, id);
				transactionsList.add(tmpTransaction);

			}
			
			System.out.println("DAOOOOOOOOOOOOOO"+transactionsList.size());

			return transactionsList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TransactionException("No transactions found for user with user id " + userId + "!", e);
		}

	}

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#getTransactionsByDate(java.sql.Date)
	 */
	@Override
	public List<Transaction> getTransactionsByDate(Date date) throws TransactionException, UserException {

		List<Transaction> transactionsList = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_TRANSACTIONS_BY_DATE_QUERY);
			ps.setDate(1, date);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String sender = resultSet.getString(2);
				String receiver = resultSet.getString(3);
				String currency = resultSet.getString(4);
				String ipOfSender = resultSet.getString(5);
				Double sum = resultSet.getDouble(6);
				Date d = resultSet.getDate(7);

				Transaction tmpTransaction = new Transaction(sender, receiver, currency, ipOfSender, sum, d, id);
				transactionsList.add(tmpTransaction);

			}

			return transactionsList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TransactionException("No transactions found for date " + date + "!", e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.ITransactionDAO#getAllTransactions()
	 */
	@Override
	public List<Transaction> getAllTransactions() throws TransactionException, UserException {
		List<Transaction> transactionsList = new ArrayList<Transaction>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM transactions;");

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String sender =resultSet.getString(2);
				String receiver = resultSet.getString(3);
				String currency = resultSet.getString(4);
				String ipOfSender = resultSet.getString(5);
				Double sum = resultSet.getDouble(6);
				Date date = resultSet.getDate(7);

				Transaction tmpTransaction = new Transaction(sender, receiver, currency, ipOfSender, sum, date, id);
				transactionsList.add(tmpTransaction);

			}

			return transactionsList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TransactionException("No transactions found!", e);
		}

	}
}
