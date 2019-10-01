package com.bridgelabz.structural.facade;

public class Pizza implements Food {

	public String preparedItems;

	@Override
	public void prepareFood(String itemsRequired) {

		preparedItems = "thin crust pizza  with ingredients " + itemsRequired;

	}

	@Override
	public String deliverFood() {

		return preparedItems;
	}

}