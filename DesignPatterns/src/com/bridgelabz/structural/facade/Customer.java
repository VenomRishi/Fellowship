package com.bridgelabz.structural.facade;

public class Customer {

	public static void main(String[] args) {
		System.out.println("--------Facade-------");
		System.out.println(Waiter.deliverFood(FoodType.PIZZA));
		System.out.println(Waiter.deliverFood(FoodType.PASTA));

	}

}
