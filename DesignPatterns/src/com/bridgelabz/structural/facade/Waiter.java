/******************************************************************************
 *  Purpose: This class will going to tell the waiter to cook the pizza and 
 *  		 pasta
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.facade;

public class Waiter {
	public static String deliverFood(FoodType foodType) {
		Ingredients ingredients = new Ingredients();
		switch (foodType) {

		case PIZZA:
			Food pizza = new Pizza();
			String pizzaItems = ingredients.getPizzaItems();
			pizza.prepareFood(pizzaItems);
			return pizza.deliverFood();

		case PASTA:
			Food pasta = new Pasta();
			String pastaItems = ingredients.getPastaItems();
			pasta.prepareFood(pastaItems);
			return pasta.deliverFood();

		}

		return null;

	}
}
