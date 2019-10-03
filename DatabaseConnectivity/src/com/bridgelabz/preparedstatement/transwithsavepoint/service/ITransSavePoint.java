/******************************************************************************
 *  Purpose: Interface of Transaction with save point.
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   01-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.preparedstatement.transwithsavepoint.service;

import java.sql.SQLException;

public interface ITransSavePoint {
	public void performTransaction() throws SQLException;
}
