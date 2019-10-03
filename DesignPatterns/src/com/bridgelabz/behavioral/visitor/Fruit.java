/******************************************************************************
 *  Purpose: Implementation of Item Element interface and this class will also
 *  	 	 tells the item element is required for fruit class
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.behavioral.visitor;

public class Fruit implements IItemElement {
	private int pricePerKg;
	private int weight;
	private String name;

	public Fruit(int priceKg, int wt, String nm) {
		this.pricePerKg = priceKg;
		this.weight = wt;
		this.name = nm;
	}

	public int getPricePerKg() {
		return pricePerKg;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int accept(IShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
