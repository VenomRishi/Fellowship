package com.bridgelabz.preparedstatement.login.service;

import java.sql.SQLException;

import com.bridgelabz.preparedstatement.login.model.Student;

public interface ILoginUtil {
	public Student checkUser(int id, String name) throws SQLException;

	public int registerUser(Student student) throws SQLException;
}
