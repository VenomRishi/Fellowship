package com.bridgelabz.behavioral.visitor;

public interface IItemElement {
	public int accept(IShoppingCartVisitor visitor);
}
