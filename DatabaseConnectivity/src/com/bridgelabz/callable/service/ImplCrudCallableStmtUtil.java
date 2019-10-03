/******************************************************************************
 *  Purpose: Implementation of Crud callable interface
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/


package com.bridgelabz.callable.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgelabz.callable.model.Student;
import com.bridgelabz.callable.repository.DbConnection;
import com.mysql.jdbc.CallableStatement;

public class ImplCrudCallableStmtUtil implements ICrudCallableStmtUtil {
	static Scanner scanner = new Scanner(System.in);
	static Connection connection = DbConnection.getConnection();
	static CallableStatement callableStatement = null;

	@Override
	public int createTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS student" + "(id int primary key," + "name varchar(50)," + "address varchar(100));";
		Statement statement = connection.createStatement();
		return statement.executeUpdate(sql);

	}

	@Override
	public int insertValues(Student student) throws SQLException {
		callableStatement = (CallableStatement) connection.prepareCall("call insert_student(?,?,?)");
		callableStatement.setInt(1, student.getId());
		callableStatement.setString(2, student.getName());
		callableStatement.setString(3, student.getAddress());
		return callableStatement.executeUpdate();
	}

	@Override
	public int updateValues(int id, Student student) throws SQLException {
		callableStatement = (CallableStatement) connection.prepareCall("call update_student(?,?,?)");
		callableStatement.setInt(1, id);
		callableStatement.setString(2, student.getName());
		callableStatement.setString(3, student.getAddress());
		return callableStatement.executeUpdate();
	}

	@Override
	public int deleteValue(int id) throws SQLException {
		callableStatement = (CallableStatement) connection.prepareCall("call delete_student(?)");
		callableStatement.setInt(1, id);
		return callableStatement.executeUpdate();

	}

	@Override
	public void showRecords() throws SQLException {

		callableStatement = (CallableStatement) connection.prepareCall("call show_student");
		ResultSet resultSet = callableStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("-->id: " + resultSet.getInt(1) + " name: " + resultSet.getString(2) + " address: "
					+ resultSet.getString(3));
		}
	}

}
