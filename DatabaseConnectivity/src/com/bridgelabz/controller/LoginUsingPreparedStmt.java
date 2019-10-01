/******************************************************************************
 *  Purpose: Program is written for creating login application using database
 *  		 connectivity to check whether user is registered in database or
 *  		 not if user exists then we have to fetch all records and show it
 *  		 else we are going to allow user to register themselves as a new 
 *  		 user.
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.ImplLoginUtil;

public class LoginUsingPreparedStmt {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		ImplLoginUtil util = new ImplLoginUtil();
		boolean isExit = false;

		System.out.println("Welcome Login App");

		while (!isExit) {

			System.out.println("1. login\n2. register\n3. exit");

			switch (scanner.nextInt()) {

			case 1:
				// login
				System.out.println("->Login<-");
				int id;
				String name;
				System.out.println("Enter id: ");
				id = scanner.nextInt();
				System.out.println("Enter name: ");
				name = scanner.next();
				Student student = util.checkUser(id, name);
				if (student != null) {
					if (student.getId() > 0) {
						System.out.println("Success login");
						System.out.println("Id: " + student.getId());
						System.out.println("Name: " + student.getName());
						System.out.println("Address: " + student.getAddress());
						isExit = true;
					} else
						System.out.println("No entry found please register first");
				}
				break;

			case 2:
				// register
				student = new Student();
				System.out.println("->Register<-");
				System.out.println("Enter id: ");
				id = scanner.nextInt();
				student.setId(id);
				System.out.println("Enter name: ");
				name = scanner.next();
				student.setName(name);
				System.out.println("Enter address: ");
				String address = scanner.next();
				student.setAddress(address);

				if (util.checkUser(id, name).getId() > 0) {
					System.out.println("You are already a member please login");
				} else {
					if (util.registerUser(student) > 0) {
						System.out.println("Register successful");
						System.out.println("Success login");
						System.out.println("Id: " + student.getId());
						System.out.println("Name: " + student.getName());
						System.out.println("Address: " + student.getAddress());
						isExit = true;
					} else
						System.out.println("Error in registering please try again");
				}

				break;

			case 3:
				// exit
				isExit = true;
				System.out.println("Thank you");
				break;

			default:
				System.out.println("invalid option");
				break;

			}
		}
		scanner.close();
	}

}
