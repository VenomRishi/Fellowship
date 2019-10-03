/******************************************************************************
 *  Purpose: Interface of crud callable utility.
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.callable.service;

import java.sql.SQLException;

import com.bridgelabz.callable.model.Student;

public interface ICrudCallableStmtUtil {

	public int createTable() throws SQLException;

	public int insertValues(Student student) throws SQLException;

	public int updateValues(int id, Student student) throws SQLException;

	public int deleteValue(int id) throws SQLException;
	
	public void showRecords() throws SQLException;
}
