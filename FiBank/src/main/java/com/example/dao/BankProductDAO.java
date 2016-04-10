package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.exception.BankProductException;
import com.example.model.BankProduct;

public class BankProductDAO extends AbstractDAO implements IBankProductDAO {
	private static final String SELECT_BANK_PRODUCT_BY_ID_QUERY = "SELECT * FROM bank_products WHERE id_bank_product = ?";
	private static final String DELETE_BANK_PRODUCT_QUERY = "DELETE FROM bank_products WHERE id_bank_product = ?";
	private static final String ADD_BANK_PRODUCT_QUERY = "INSERT INTO bank_products VALUES (null, ?,?,?,?)";

	/* (non-Javadoc)
	 * @see com.example.model.IBankProductDAO#addBankProduct(com.example.model.BankProduct)
	 */
	@Override
	public int addBankProduct(BankProduct product) throws BankProductException {
		if (product != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(ADD_BANK_PRODUCT_QUERY,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, product.getName());
				ps.setDouble(2, product.getInterest());
				ps.setDouble(3, product.getMinSum());
				ps.setInt(4, product.getPeriodInMonths());

				ps.executeUpdate();

				ResultSet id = ps.getGeneratedKeys();
				id.next();
				return id.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new BankProductException("Can't add a bank product!", e);
			}
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.model.IBankProductDAO#removeBankProduct(int)
	 */
	@Override
	public void removeBankProduct(int productId) throws BankProductException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_BANK_PRODUCT_QUERY);
			ps.setInt(1, productId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankProductException("Can't delete a product with ID : " + productId, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.IBankProductDAO#getBankProductById(int)
	 */
	@Override
	public BankProduct getBankProductById(int productId) throws BankProductException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_BANK_PRODUCT_BY_ID_QUERY);
			ps.setInt(1, productId);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			String name = result.getString(2);
			double interest = result.getDouble(3);
			double minSum=result.getDouble(4);
			int periodInMonths=result.getInt(5);

			return new BankProduct(name, interest, minSum, periodInMonths, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankProductException("Can't find a bank product with ID : " + productId, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.IBankProductDAO#getAllBankProducts()
	 */
	@Override
	public List<BankProduct> getAllBankProducts() throws BankProductException {
		List<BankProduct> productsList = new ArrayList<BankProduct>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM bank_products;");
			
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				double interest = resultSet.getDouble(3);
				double minSum=resultSet.getDouble(4);
				int periodInMonths=resultSet.getInt(5);

				BankProduct tmpProduct=new BankProduct(name, interest, minSum, periodInMonths,id);
				
				productsList.add(tmpProduct);
			}
			
			return productsList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankProductException("No bank products found!", e);
		}
		
	}


}
