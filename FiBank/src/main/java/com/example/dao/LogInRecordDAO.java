package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.example.exception.LogInRecordException;
import com.example.exception.UserException;
import com.example.model.LogInRecord;
import com.example.model.User;

public class LogInRecordDAO extends AbstractDAO implements ILogInRecordDAO {

	private static final String SELECT_LOG_IN_RECORD_BY_ID_QUERY = "SELECT * FROM login_history WHERE id_login_history = ?";
	private static final String SELECT_LOG_IN_RECORDS_BY_USER_ID_QUERY = "SELECT * FROM login_history WHERE id_of_user_who_logged_in = ? ORDER BY date";
	private static final String SELECT_LOG_IN_RECORDS_BY_DATE_QUERY = "SELECT * FROM login_history WHERE date = ?";
	private static final String DELETE_LOG_IN_RECORD_BY_ID_QUERY = "DELETE FROM login_history WHERE id_login_history= ?";
	private static final String DELETE_LOG_IN_RECORDS_BY_USER_QUERY = "DELETE FROM login_history WHERE id_of_user_who_logged_in= ?";
	private static final String DELETE_LOG_IN_RECORDS_BY_DATE_QUERY = "DELETE FROM login_history WHERE date= ?";
	private static final String ADD_LOG_IN_RECORD_QUERY = "INSERT INTO login_history VALUES (null, ?,?,?)";

	

	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#addLogInRecord(com.example.model.LogInRecord)
	 */
	@Override
	public int addLogInRecord(LogInRecord record) throws LogInRecordException {
		if (record != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(ADD_LOG_IN_RECORD_QUERY,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setDate(1, (Date) record.getDate());
				ps.setString(2, record.getUser().getId());
				ps.setString(3, record.getIp());

				ps.executeUpdate();

				ResultSet id = ps.getGeneratedKeys();
				id.next();
				return id.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new LogInRecordException("Can't add a log in record!", e);
			}
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#removeLogInRecordById(int)
	 */
	@Override
	public void removeLogInRecordById(int recordId) throws LogInRecordException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_LOG_IN_RECORD_BY_ID_QUERY);
			ps.setInt(1, recordId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LogInRecordException("Can't delete a log in record with ID : " + recordId, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#removeLogInRecordsForUser(com.example.model.User)
	 */
	@Override
	public void removeLogInRecordsForUser(User user) throws LogInRecordException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_LOG_IN_RECORDS_BY_USER_QUERY);
			ps.setString(1, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LogInRecordException("Can't delete a log in records for user with USER ID : " + user.getId(), e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#removeLogInRecordsForDate(java.sql.Date)
	 */
	@Override
	public void removeLogInRecordsForDate(Date date) throws LogInRecordException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_LOG_IN_RECORDS_BY_DATE_QUERY);
			ps.setDate(1, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LogInRecordException("Can't delete a log in records for date : " + date, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#getLogInRecordById(int)
	 */
	@Override
	public LogInRecord getLogInRecordById(int recordId) throws LogInRecordException, UserException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_LOG_IN_RECORD_BY_ID_QUERY);
			ps.setInt(1, recordId);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			Date date=result.getDate(2);
			IUserDAO userDAO=new UserDAO();
			User user=userDAO.getUserById(result.getString(3));
			String ip = result.getString(4);

			return new LogInRecord(date,user, ip, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LogInRecordException("Can't find a log in record with ID : " + recordId, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#getLogInRecordsByUserId(java.lang.String)
	 */
	@Override
	public List<LogInRecord> getLogInRecordsByUserId(String userId) throws LogInRecordException, UserException {
			List<LogInRecord> recordsList = new ArrayList<LogInRecord>();
			try {
				PreparedStatement ps = getCon().prepareStatement(SELECT_LOG_IN_RECORDS_BY_USER_ID_QUERY);
				ps.setString(1, userId);
				ResultSet resultSet = ps.executeQuery();
				
				 while (resultSet.next()) {
					int id = resultSet.getInt(1);
					Date date=resultSet.getDate(2);
					IUserDAO userDAO=new UserDAO();
					User user=userDAO.getUserById(resultSet.getString(3));
					String ip = resultSet.getString(4);
					
					LogInRecord tmpRecord=new LogInRecord(date, user, ip, id);
					recordsList.add(tmpRecord);
					
				}
				
				return recordsList;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new LogInRecordException("No records found for user with user id "+userId+"!", e);
			}
			
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#getLogInRecordsByDate(java.sql.Date)
	 */
	@Override
	public List<LogInRecord> getLogInRecordsByDate(Date date) throws LogInRecordException, UserException {

		List<LogInRecord> recordsList = new ArrayList<LogInRecord>();
		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_LOG_IN_RECORDS_BY_DATE_QUERY);
			ps.setDate(1, date);
			ResultSet resultSet = ps.executeQuery();
			
			 while (resultSet.next()) {
				int id = resultSet.getInt(1);
				Date d=resultSet.getDate(2);
				IUserDAO userDAO=new UserDAO();
				User user=userDAO.getUserById(resultSet.getString(3));
				String ip = resultSet.getString(4);
				
				LogInRecord tmpRecord=new LogInRecord(d, user, ip, id);
				recordsList.add(tmpRecord);
				
			}
			
			return recordsList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LogInRecordException("No records found for date "+date+"!", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.example.model.ILogInRecordDAO#getAllLogInRecords()
	 */
	@Override
	public List<LogInRecord> getAllLogInRecords() throws LogInRecordException, UserException {
		List<LogInRecord> recordsList = new ArrayList<LogInRecord>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM login_history;");
			
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				Date date=resultSet.getDate(2);
				IUserDAO userDAO=new UserDAO();
				User user=userDAO.getUserById(resultSet.getString(3));
				String ip = resultSet.getString(4);
				
				LogInRecord tmpRecord=new LogInRecord(date, user, ip, id);
				recordsList.add(tmpRecord);
				
			}
			
			return recordsList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LogInRecordException("No records found!", e);
		}
		
	}
}
