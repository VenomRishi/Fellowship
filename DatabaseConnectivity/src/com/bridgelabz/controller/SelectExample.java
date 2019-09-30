package com.bridgelabz.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.repository.DbConnection;

public class SelectExample {
	public static void main(String a[]) throws SQLException {
		String query = "select * from student";

		Connection connection = DbConnection.getConnection();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}

		st.close();
		connection.close();
	}
}
