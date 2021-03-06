/******************************************************************************
 *  Purpose: Implementation of Crud using prepared statement utility
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.preparedstatement.crud.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.preparedstatement.crud.model.Student;
import com.bridgelabz.preparedstatement.crud.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class ImplCrudPreparedStmtUtil implements ICrudPreparedStmtUtil {
	static Scanner scanner = new Scanner(System.in);
	static Connection connection = DbConnection.getConnection();
	static PreparedStatement preparedStatement = null;

	/**
	 * Purpose: method for creating table into database using prepared statement
	 */
	@Override
	public int createTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS student" + "(id int primary key," + "name varchar(50),"
				+ "address varchar(100));";
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

		return preparedStatement.executeUpdate();
	}

	/**
	 * Purpose: method for showing records from database using prepared statement
	 */
	@Override
	public void showRecords() throws SQLException {
		String query = "select * from student";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			System.out.println("-->id: " + rs.getInt(1) + " name: " + rs.getString(2) + " address: " + rs.getString(3));
		}
	}

	/**
	 * Purpose: method for inserting values into database using prepared statement
	 */
	@Override
	public int insertValues(Student student) throws SQLException {
		String query = "insert into student values(?,?,?)";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getAddress());

		return preparedStatement.executeUpdate();
	}

	/**
	 * Purpose: method for updating values into database using prepared statement
	 */
	@Override
	public int updateValues(int id, Student student) throws SQLException {
		String query = "UPDATE student SET name=?, address=? WHERE id=?";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setString(1, student.getName());
		preparedStatement.setString(2, student.getAddress());
		preparedStatement.setInt(3, id);
		return preparedStatement.executeUpdate();
	}

	/**
	 * Purpose: method for deleting values into database using prepared statement
	 */
	@Override
	public int deleteValue(int id) throws SQLException {
		String query = "DELETE FROM student WHERE id=?";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate();
	}

	@Override
	public void closeCon() throws SQLException {
		// TODO Auto-generated method stub
		scanner.close();
		preparedStatement.close();
		connection.close();

	}
}
