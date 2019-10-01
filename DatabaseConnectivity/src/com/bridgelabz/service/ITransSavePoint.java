package com.bridgelabz.service;

import java.sql.SQLException;

public interface ITransSavePoint {
	public void performTransaction() throws SQLException;
}
