package com.bridgelabz.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgelabz.model.Student;
import com.bridgelabz.repository.DbConnection;

public class ImplCrudStatementUtil implements ICrudStatementUtil {
	static Connection connection = DbConnection.getConnection();
	static Statement statement = null;
	Student student = new Student();

	@Override
	public String createTable() throws SQLException {
		String sql = "CREATE TABLE student" + "(id int primary key," + "name varchar(50)," + "address varchar(100));";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		return "table created successfully";

	}

	@Override
	public void showRecords() throws SQLException {
		String query = "select * from student";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2) + " address: " + rs.getString(3));
		}

	}

	@Override
	public int insertValues(Student student) throws SQLException {
		String query = "insert into student values(" + student.getId() + ",'" + student.getName() + "','"
				+ student.getAddress() + "')";
		statement = connection.createStatement();
		int rowsAffected = statement.executeUpdate(query);
		return rowsAffected;
	}

	@Override
	public int updateValues(String query) throws SQLException {

		statement = connection.createStatement();

		return statement.executeUpdate(query);
	}

	@Override
	public int deleteValue(int id) throws SQLException {

		String query = "DELETE FROM student WHERE id='" + id + "'";
		statement = connection.createStatement();

		return statement.executeUpdate(query);
	}

	@Override
	public int updateValues(int id) throws SQLException {
		String query = "UPDATE student SET name='" + student.getName() + "', address='" + student.getAddress()
				+ "' WHERE id=" + id + "";
		statement = connection.createStatement();

		return statement.executeUpdate(query);
	}

}
