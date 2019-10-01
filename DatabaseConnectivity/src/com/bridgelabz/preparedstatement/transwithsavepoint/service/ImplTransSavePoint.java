package com.bridgelabz.preparedstatement.transwithsavepoint.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.bridgelabz.preparedstatement.transwithsavepoint.repository.DbConnection;
import com.mysql.jdbc.PreparedStatement;

public class ImplTransSavePoint implements ITransSavePoint {
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;

	@Override
	public void performTransaction() throws SQLException {
		String query1 = "INSERT INTO student VALUES(?,?,?)";
		connection = DbConnection.getConnection();
		connection.setAutoCommit(false);

		preparedStatement = (PreparedStatement) connection.prepareStatement(query1);
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, "rishi");
		preparedStatement.setString(3, "panvel");
		preparedStatement.executeUpdate();

		preparedStatement.setInt(1, 2);
		preparedStatement.setString(2, "abhya");
		preparedStatement.setString(3, "bhandup");
		preparedStatement.executeUpdate();

		preparedStatement.setInt(1, 3);
		preparedStatement.setString(2, "vishnu");
		preparedStatement.setString(3, "latur");
		preparedStatement.executeUpdate();
		Savepoint savepoint = connection.setSavepoint();

		preparedStatement.setInt(1, 4);
		preparedStatement.setString(2, "priya");
		preparedStatement.setString(3, "latur");
		preparedStatement.executeUpdate();

		preparedStatement.setInt(1, 5);
		preparedStatement.setString(2, "mark");
		preparedStatement.setString(3, "chembur");
		preparedStatement.executeUpdate();

		// Rollback to savepoint
		connection.rollback(savepoint);

		// Commit statement
		connection.commit();

	}

}
