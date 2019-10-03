/******************************************************************************
 *  Purpose: Interface of login applications which has methods like check user
 *  		 and register user
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/


package com.bridgelabz.preparedstatement.login.service;

import java.sql.SQLException;

import com.bridgelabz.preparedstatement.login.model.Student;

public interface ILoginUtil {
	public Student checkUser(int id, String name) throws SQLException;

	public int registerUser(Student student) throws SQLException;
}
