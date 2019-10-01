/******************************************************************************
 *  Purpose: Program is written for performing database crud operation using 
 *  		 java application with using prepared statement
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.preparedstatement.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.preparedstatement.model.Student;
import com.bridgelabz.preparedstatement.service.ImplCrudPreparedStmtUtil;

public class CrudUsingPreparedStmt {
	public static void main(String[] args) throws SQLException {
		ImplCrudPreparedStmtUtil util = new ImplCrudPreparedStmtUtil();
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();

		boolean isExit = false;
		while (!isExit) {
			System.out.println(
					"1. create table\n2. insert value\n3.update value\n4.delete value\n5. show records\n6. exit");
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("--------creating table---------");
				if (util.createTable() == 0)
					System.out.println("table already exists");
				else
					System.out.println("created table successfully..");
				break;
			case 2:
				System.out.println("--------inserting new values---------");

				System.out.println("Enter id: ");
				student.setId(scanner.nextInt());
				System.out.println("Enter name: ");
				student.setName(scanner.next());
				System.out.println("Enter Address: ");
				student.setAddress(scanner.next());

				System.out.println("Row's affected: " + util.insertValues(student));
				break;
			case 3:
				System.out.println("--------updating new values---------");

				System.out.println("Enter id you want to update: ");
				int id = scanner.nextInt();
				System.out.println("Enter name to change: ");
				student.setName(scanner.next());
				System.out.println("Enter address to change: ");
				student.setAddress(scanner.next());

				System.out.println("Row's affected: " + util.updateValues(id, student));
				break;
			case 4:
				System.out.println("--------deleting new values---------");

				System.out.println("Enter id you want to delete: ");
				int idToDelete = scanner.nextInt();

				System.out.println("Row's affected: " + util.deleteValue(idToDelete));
				break;
			case 5:
				util.showRecords();
				break;
			case 6:
				isExit = true;
				System.out.println("Thank you");
				break;

			}
		}

		scanner.close();

	}

}
