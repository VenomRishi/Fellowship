/******************************************************************************
 *  Purpose: Implementation of Crud statement interface
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.statement.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.statement.model.Student;
import com.bridgelabz.statement.repository.DbConnection;

public class ImplCrudStmtUtil implements ICrudStmtUtil {
	static Connection connection = DbConnection.getConnection();
	static Statement statement = null;

	@Override
	public int createTable() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS student" + "(id int primary key," + "name varchar(50),"
				+ "address varchar(100));";
		statement = connection.createStatement();

		return statement.executeUpdate(sql);

	}

	@Override
	public void showRecords() throws SQLException {
		String query = "select * from student";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			System.out.println("-->id: " + rs.getInt(1) + " name: " + rs.getString(2) + " address: " + rs.getString(3));
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
	public int updateValues(int id, Student student) throws SQLException {
		String query = "UPDATE student SET name='" + student.getName() + "', address='" + student.getAddress()
				+ "' WHERE id=" + id + "";
		statement = connection.createStatement();

		return statement.executeUpdate(query);
	}

	@Override
	public int deleteValue(int id) throws SQLException {

		String query = "DELETE FROM student WHERE id='" + id + "'";
		statement = connection.createStatement();

		return statement.executeUpdate(query);
	}

}
