/******************************************************************************
 *  Purpose: Program is written for doing batch processing operation of 
 *  		 database using addBatch(), executeBatch() method using 
 *  		 prepared statement
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.bridgelabz.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class BatchProcessingPs {
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;

	public static void main(String[] args) throws SQLException {
		System.out.println("Performing batch processing for inserting records in database");
		int[] arr = executeAllQuery();
		System.out.println("Status of all query");
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	private static int[] executeAllQuery() throws SQLException {
		//String delete = "DELETE FROM student";
		String query1 = "INSERT INTO student VALUES(?,?,?)";
		connection = DbConnection.getConnection();

//		preparedStatement = (PreparedStatement) connection.prepareStatement(delete);
//		preparedStatement.addBatch(delete);
		preparedStatement = (PreparedStatement) connection.prepareStatement(query1);
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, "rishi");
		preparedStatement.setString(3, "panvel");
		preparedStatement.addBatch();

		preparedStatement.setInt(1, 2);
		preparedStatement.setString(2, "abhya");
		preparedStatement.setString(3, "bhandup");
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setString(2, "vishnu");
		preparedStatement.setString(3, "latur");
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 4);
		preparedStatement.setString(2, "priya");
		preparedStatement.setString(3, "latur");
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 5);
		preparedStatement.setString(2, "mark");
		preparedStatement.setString(3, "chembur");
		preparedStatement.addBatch();
		
		return preparedStatement.executeBatch();
	}

}
