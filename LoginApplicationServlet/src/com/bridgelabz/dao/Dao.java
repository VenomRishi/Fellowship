/******************************************************************************
 *  Purpose: This class is used to handle the database operation like register
 *  		 a user, validating whether user is exist in the database or not
 *  		 and this class uses dao design pattern
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   04-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;
import com.bridgelabz.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class Dao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * Purpose: method for reading username and password is present or not in user
	 * table from database
	 * 
	 * @param username input from program
	 * @param password input from program
	 * @return returns true username and password exist in the database else return
	 *         false
	 * @throws ClassNotFoundException exception is generate if Class.forName method
	 *                                does not find the class name
	 * @throws SQLException           exception is generate if error occur while
	 *                                creating connection with database
	 */
	public boolean readFromDatabase(String username, String password) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM user WHERE username=? AND password=?";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			return true;
		}

		return false;
	}

	/**
	 * Purpose: method for reading user name is present or not in user table from
	 * database
	 * 
	 * @param username input from program
	 * @return returns true user name and password exist in the database else return
	 *         false
	 * @throws ClassNotFoundException exception is generate if Class.forName method
	 *                                does not find the class name
	 * @throws SQLException           exception is generate if error occur while
	 *                                creating connection with database
	 */
	public boolean checkUsernameFromDatabase(String username) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM user WHERE username=?";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setString(1, username);

		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			return true;
		}

		return false;
	}

	/**
	 * Purpose: method for inserting details of user into database
	 * 
	 * @param user model object of user class which will help in getting data from
	 *             model
	 * @return returns true if row affected in the database or else return false
	 * @throws SQLException           exception is generate if error occur while
	 *                                creating connection with database
	 * @throws ClassNotFoundException exception is generate if Class.forName method
	 *                                does not find the class name
	 */
	public boolean insertIntoDatabase(User user) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO user(fname,lname,username,password,dateupdated) VALUES(?,?,?,?,?)";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);

		preparedStatement.setString(1, user.getFname());
		preparedStatement.setString(2, user.getLname());
		preparedStatement.setString(3, user.getUsername());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getDateupdated());

		if (preparedStatement.executeUpdate() == 1)
			return true;

		return false;
	}

	/**
	 * Purpose: method for reading data from database and returning result set
	 * 
	 * @param username	input from user
	 * @return	returns the data in the object of result set
	 * @throws SQLException           exception is generate if error occur while
	 *                                creating connection with database
	 * @throws ClassNotFoundException exception is generate if Class.forName method
	 *                                does not find the class name
	 */
	public ResultSet readAllFromDatabase(String username) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM user WHERE username=?";
		connection = DbConnection.getConnection();
		preparedStatement = (PreparedStatement) connection.prepareStatement(query);
		preparedStatement.setString(1, username);

		ResultSet rs = preparedStatement.executeQuery();

		return rs;

	}

	/**
	 * Purpose: method for closing all open connection for prepared statement and
	 * database connection
	 * 
	 * @throws SQLException exception is generate if error occur while creating
	 *                      connection with database
	 */
	public void close() throws SQLException {

		preparedStatement.close();
		connection.close();

	}
}
