package com.bridgelabz.service;

import java.sql.SQLException;

import com.bridgelabz.model.Student;

public interface ICrudPreparedStmtUtil {
	public int createTable() throws SQLException;

	public void showRecords() throws SQLException;

	public int insertValues(Student student) throws SQLException;

	public int updateValues(int id, Student student) throws SQLException;

	public int deleteValue(int id) throws SQLException;
}
