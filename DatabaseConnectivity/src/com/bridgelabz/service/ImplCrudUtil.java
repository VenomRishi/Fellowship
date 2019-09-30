package com.bridgelabz.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgelabz.model.Student;
import com.bridgelabz.repository.DbConnection;

public class ImplCrudUtil implements ICrudUtil {
	static Scanner scanner = new Scanner(System.in);
	static Connection connection = DbConnection.getConnection();
	static Statement st = null;
	Student student = new Student();

	@Override
	public String createTable() throws SQLException {
		String sql = "CREATE TABLE student" + "(id int primary key," + "name varchar(50)," + "address varchar(100));";
		st = connection.createStatement();
		st.executeUpdate(sql);
		return "table created successfully";

	}

	@Override
	public Student getValuesInsert() {

		System.out.println("Enter id: ");
		student.setId(scanner.nextInt());
		System.out.println("Enter name: ");
		student.setName(scanner.next());
		System.out.println("Enter Address: ");
		student.setAddress(scanner.next());
		return student;
	}

	@Override
	public void showRecords() throws SQLException {
		String query = "select * from student";
		st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2) + " address: " + rs.getString(3));
		}

	}

	@Override
	public int insertValues(Student student) throws SQLException {
		String query = "insert into student values(" + student.getId() + ",'" + student.getName() + "','"
				+ student.getAddress() + "')";
		st = connection.createStatement();
		int rowsAffected = st.executeUpdate(query);
		return rowsAffected;
	}

	@Override
	public String getValuesUpdate() {
		System.out.println("Enter id you want to update: ");
		int id = scanner.nextInt();
		System.out.println("Enter name to change: ");
		student.setName(scanner.next());
		System.out.println("Enter address to change: ");
		student.setAddress(scanner.next());
		String query = "UPDATE student SET name='" + student.getName() + "', address='" + student.getAddress()
				+ "' WHERE id=" + id + "";
		return query;
	}

	@Override
	public int updateValues(String query) throws SQLException {

		st = connection.createStatement();

		return st.executeUpdate(query);
	}

	@Override
	public int deleteValue() throws SQLException {
		System.out.println("Enter id you want to delete: ");
		int id = scanner.nextInt();
		String query = "DELETE FROM student WHERE id='" + id + "'";
		st = connection.createStatement();

		return st.executeUpdate(query);
	}

}
