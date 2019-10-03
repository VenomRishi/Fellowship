/******************************************************************************
 *  Purpose: Interface of Shopping card of visitor
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.behavioral.visitor;

public interface IShoppingCartVisitor {
	int visit(Book book);

	int visit(Fruit fruit);
}
