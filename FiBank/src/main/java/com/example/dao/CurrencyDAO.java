package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.exception.CurrencyException;
import com.example.exception.UserException;
import com.example.model.Currency;

public class CurrencyDAO extends AbstractDAO implements ICurrencyDAO{

	private static final String SELECT_CURRENCY_BY_NAME_QUERY = "SELECT * FROM currency WHERE currency = ?";
	private static final String DELETE_CURRENCY_QUERY = "DELETE FROM currency WHERE currency = ?";
	private static final String UPDATE_CURRENCY_QUERY = "UPDATE currency SET fixing=?, buying=?, selling=? WHERE currency=?";


	/* (non-Javadoc)
	 * @see com.example.dao.ICurrencyDAO#removeCurrency(java.lang.String)
	 */
	@Override
	public void removeCurrency(String currency) throws CurrencyException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_CURRENCY_QUERY);
			ps.setString(1, currency);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CurrencyException("Can't delete a currency : " + currency, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.dao.ICurrencyDAO#getCurrency(java.lang.String)
	 */
	@Override
	public Currency getCurrency(String currency) throws CurrencyException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_CURRENCY_BY_NAME_QUERY);
			ps.setString(1, currency);
			ResultSet result = ps.executeQuery();
			result.next();
			String name = result.getString(1);
			double fixing = result.getDouble(2);

			return new Currency(name, fixing);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CurrencyException("Can't find currency : " + currency, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.dao.ICurrencyDAO#getAllCurrencies()
	 */
	@Override
	public List<Currency> getAllCurrencies() throws CurrencyException {
		List<Currency> currencyList = new ArrayList<Currency>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM currency;");
			
			while (resultSet.next()) {
				String name = resultSet.getString(1);
				double fixing = resultSet.getDouble(2);
		
				currencyList.add(new Currency(name, fixing));
			}
			
			return currencyList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CurrencyException("No currency found!", e);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.example.dao.ICurrencyDAO#updadeCurrency(java.lang.String, double)
	 */
	@Override
	public String updadeCurrency(String currency, double  newFixing) throws CurrencyException {
		if (currency != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(UPDATE_CURRENCY_QUERY);
				Currency tmp=new Currency(currency, newFixing);
				ps.setDouble(1, newFixing);
				ps.setDouble(2, tmp.getBuying());
				ps.setDouble(3, tmp.getSelling());
				ps.setString(4,currency);
				
				ps.executeUpdate();

				return currency;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new CurrencyException("Can't change currency : "+currency, e);
			}
		}
		return null;
	}

}
