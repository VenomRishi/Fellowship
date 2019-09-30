package com.bridgelabz.behavioral.visitor;

public class Book implements IItemElement {
	private int price;
	private String isbnNumber;

	public Book(int cost, String isbn) {
		this.price = cost;
		this.isbnNumber = isbn;
	}

	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	@Override
	public int accept(IShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
