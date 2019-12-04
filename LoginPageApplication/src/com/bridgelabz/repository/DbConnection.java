package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection connection = null;

	/**
	 * Purpose: method for establishing connection with the database
	 * 
	 * @return returns the established connection
	 * @throws SQLException           if there's any exception occur while creating
	 *                                connection with the database then this can be
	 *                                handle by the SQLException
	 * @throws ClassNotFoundException if while searching class from
	 *                                com.mysql.jdbc.Driver if that reflection api
	 *                                unable to find this class then this error will
	 *                                handle by class not found exception
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/clgdb?verifyServerCertificate=false&useSSL=true", "root", "root");

		return connection;
	}
}
