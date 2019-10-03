/******************************************************************************
 *  Purpose: Interface of Item Element
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.behavioral.visitor;

public interface IItemElement {
	public int accept(IShoppingCartVisitor visitor);
}
