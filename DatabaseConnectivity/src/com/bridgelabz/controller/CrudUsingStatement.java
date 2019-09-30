package com.bridgelabz.controller;

import java.sql.SQLException;
import com.bridgelabz.model.Student;
import com.bridgelabz.service.ImplCrudUtil;

public class CrudUsingStatement {

	public static void main(String[] args) throws SQLException {

		ImplCrudUtil util = new ImplCrudUtil();
		// creating table
		//System.out.println(util.createTable());

		// util.showRecords();

		System.out.println("inserting new values");
		Student student = util.getValuesInsert();
		// inserting new values

		System.out.println("Row's affected: " + util.insertValues(student));
		util.showRecords();
		String query = util.getValuesUpdate();
		System.out.println("Row's affected: " + util.updateValues(query));
		util.showRecords();
		System.out.println("Row's affected: " +util.deleteValue());
		util.showRecords();
	}

}
