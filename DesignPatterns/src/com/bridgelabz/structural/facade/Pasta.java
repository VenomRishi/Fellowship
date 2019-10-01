package com.bridgelabz.structural.facade;

public class Pasta implements Food {

	public String preparedItems;
	@Override
	public void prepareFood(String itemsRequired) {
		
		preparedItems="tamato pasta  with ingredients "+itemsRequired;
	}

	@Override
	public String deliverFood() {
		
		return preparedItems;
	}

}
