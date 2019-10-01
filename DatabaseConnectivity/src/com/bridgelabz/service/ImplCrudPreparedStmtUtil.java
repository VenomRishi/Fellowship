package com.bridgelabz.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.model.Student;
import com.bridgelabz.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class ImplCrudPreparedStmtUtil implements ICrudPreparedStmtUtil {
	static Scanner scanner = new Scanner(System.in);
	static Connection connection = DbConnection.getConnection();
	static PreparedStatement preparedStatement = null;

	@Override
	public int createTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS student" + "(id int primary key," + "name varchar(50)," + "address varchar(100));";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

		return preparedStatement.executeUpdate();
	}

	@Override
	public void showRecords() throws SQLException {
		String query = "select * from student";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			System.out.println("-->id: " + rs.getInt(1) + " name: " + rs.getString(2) + " address: " + rs.getString(3));
		}
	}

	@Override
	public int insertValues(Student student) throws SQLException {
		String query = "insert into student values(?,?,?)";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getAddress());

		return preparedStatement.executeUpdate();
	}

	@Override
	public int updateValues(int id, Student student) throws SQLException {
		String query = "UPDATE student SET name='" + student.getName() + "', address='" + student.getAddress()
				+ "' WHERE id=" + id + "";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);

		return preparedStatement.executeUpdate();
	}

	@Override
	public int deleteValue(int id) throws SQLException {
		String query = "DELETE FROM student WHERE id='" + id + "'";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);

		return preparedStatement.executeUpdate();
	}
}
