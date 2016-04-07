package com.example.dao;

import java.sql.Date;
import java.util.List;

import com.example.exception.LogInRecordException;
import com.example.exception.UserException;
import com.example.model.LogInRecord;
import com.example.model.User;

public interface ILogInRecordDAO {

	int addLogInRecord(LogInRecord record) throws LogInRecordException;

	void removeLogInRecordById(int recordId) throws LogInRecordException;

	void removeLogInRecordsForUser(User user) throws LogInRecordException;

	void removeLogInRecordsForDate(Date date) throws LogInRecordException;

	LogInRecord getLogInRecordById(int recordId) throws LogInRecordException, UserException;

	List<LogInRecord> getLogInRecordsByUserId(String userId) throws LogInRecordException, UserException;

	List<LogInRecord> getLogInRecordsByDate(Date date) throws LogInRecordException, UserException;

	List<LogInRecord> getAllLogInRecords() throws LogInRecordException, UserException;

}