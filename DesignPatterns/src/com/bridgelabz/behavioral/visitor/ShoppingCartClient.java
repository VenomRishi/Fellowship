/******************************************************************************
 *  Purpose: Program is written for design pattern of visitor
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.behavioral.visitor;

public class ShoppingCartClient {
	public static void main(String[] args) {
		IItemElement[] items = new IItemElement[] { new Book(20, "1234"), new Book(100, "5678"),
				new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple") };

		int total = calculatePrice(items);
		System.out.println("Total Cost = " + total);
	}

	private static int calculatePrice(IItemElement[] items) {
		IShoppingCartVisitor visitor = new ImplShoppingCartVisitor();
		int sum = 0;
		for (IItemElement item : items) {
			sum = sum + item.accept(visitor);
		}
		return sum;
	}
}
