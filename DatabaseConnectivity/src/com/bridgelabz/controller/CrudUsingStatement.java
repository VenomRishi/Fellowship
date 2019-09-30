package com.bridgelabz.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.ImplCrudStatementUtil;

public class CrudUsingStatement {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);

		ImplCrudStatementUtil util = new ImplCrudStatementUtil();
		// creating table
		System.out.println("--------creating table---------");
		// System.out.println(util.createTable());

		System.out.println("--------inserting new values---------");
		Student student = new Student();
		System.out.println("Enter id: ");
		student.setId(scanner.nextInt());
		System.out.println("Enter name: ");
		student.setName(scanner.next());
		System.out.println("Enter Address: ");
		student.setAddress(scanner.next());
//		Student student = util.getValuesInsert();
		// inserting new values

		System.out.println("Row's affected: " + util.insertValues(student));
		util.showRecords();
		System.out.println("--------updating new values---------");
		// String query = util.getValuesUpdate();
		System.out.println("Enter id you want to update: ");
		int id = scanner.nextInt();
		System.out.println("Enter name to change: ");
		student.setName(scanner.next());
		System.out.println("Enter address to change: ");
		student.setAddress(scanner.next());
		System.out.println("Row's affected: " + util.updateValues(id));
		util.showRecords();
		System.out.println("--------deleting new values---------");
		System.out.println("Enter id you want to delete: ");
		int idToDelete = scanner.nextInt();
		System.out.println("Row's affected: " + util.deleteValue(idToDelete));
		util.showRecords();
		
		scanner.close();
	}

}
