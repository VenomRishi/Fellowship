package com.bridgelabz.service;

import java.sql.SQLException;

import com.bridgelabz.model.Student;

public interface ICrudStatementUtil {
	public String createTable() throws SQLException;

	public void showRecords() throws SQLException;

	public int insertValues(Student student) throws SQLException;

	public int updateValues(String query) throws SQLException;

	int deleteValue(int id) throws SQLException;

	int updateValues(int id) throws SQLException;
}
