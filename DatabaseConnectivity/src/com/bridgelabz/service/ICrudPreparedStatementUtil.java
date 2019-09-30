package com.bridgelabz.service;

import java.sql.SQLException;

import com.bridgelabz.model.Student;

public interface ICrudPreparedStatementUtil {
	public String createTable() throws SQLException;

	public Student getValuesInsert();

	public void showRecords() throws SQLException;

	public int insertValues(Student student) throws SQLException;

	public String getValuesUpdate();

	public int updateValues(String query) throws SQLException;

	int deleteValue() throws SQLException;
}
