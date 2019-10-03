/******************************************************************************
 *  Purpose: Program is written for design pattern of Facade
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.facade;

public class Customer {

	public static void main(String[] args) {
		System.out.println("--------Facade-------");
		System.out.println(Waiter.deliverFood(FoodType.PIZZA));
		System.out.println(Waiter.deliverFood(FoodType.PASTA));

	}

}
