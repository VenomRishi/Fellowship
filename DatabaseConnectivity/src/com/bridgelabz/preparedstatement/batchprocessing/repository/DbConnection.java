/******************************************************************************
 *  Purpose: Class can establishes connection with database using jdbc
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.preparedstatement.batchprocessing.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static String url = "jdbc:mysql://localhost:3306/clgdb?verifyServerCertificate=false&useSSL=true";
	static String username = "root";
	static String password = "";
	static Connection connection = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

}
