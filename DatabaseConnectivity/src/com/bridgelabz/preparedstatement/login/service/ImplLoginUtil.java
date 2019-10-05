/******************************************************************************
 *  Purpose: Implementation of Login application interface utility
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.preparedstatement.login.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.preparedstatement.login.model.Student;
import com.bridgelabz.preparedstatement.login.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class ImplLoginUtil implements ILoginUtil {
	static Connection connection = DbConnection.getConnection();
	static PreparedStatement preparedStatement = null;

	/**
	 * Purpose: method for checking user is there in database or not
	 */
	@Override
	public Student checkUser(int id, String name) throws SQLException {
		Student student = new Student();
		String query = "select * from student where id=? and name=?";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			student.setId(resultSet.getInt(1));
			student.setName(resultSet.getString(2));
			student.setAddress(resultSet.getString(3));
		}

		return student;
	}

	/**
	 * Purpose: method for inserting new user into database
	 */
	@Override
	public int registerUser(Student student) throws SQLException {

		String query = "insert into student values(?,?,?)";
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getAddress());

		return preparedStatement.executeUpdate();
	}

}
