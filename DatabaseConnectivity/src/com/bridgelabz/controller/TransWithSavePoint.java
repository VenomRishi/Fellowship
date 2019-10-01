/******************************************************************************
 *  Purpose: Program is written for persisting the data into database within 
 *  		 which we are using transaction save point which will make data
 *  		 persistent into database ever after we are going to fire rollback
 *  		 command only data remove after save point
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.controller;

import java.sql.SQLException;

import com.bridgelabz.service.ImplTransSavePoint;

public class TransWithSavePoint {

	public static void main(String[] args) throws SQLException {
		System.out.println("Performing transactions with save point");
		System.out.println("and between we roll back to don't persist the changes");
		ImplTransSavePoint util = new ImplTransSavePoint();
		util.performTransaction();
		System.out.println("Transactions done with save point");
	}

}
