package com.bridgelabz.service;

import java.sql.SQLException;

import com.bridgelabz.model.Student;

public interface ILoginUtil {
	public Student checkUser(int id, String name) throws SQLException;

	public int registerUser(Student student) throws SQLException;
}
