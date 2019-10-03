/******************************************************************************
 *  Purpose: Program is written for design pattern of prototype
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.prototype;

public class PrototypeMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		BookShop bs = new BookShop();
		bs.setShopName("Deepak book shop");
		bs.loadData();

		// it is again going into database and fetching the data
		// we are going to ask first object to share data
//		BookShop bs1 = new BookShop();
//		bs1.setShopName("A1");
//		bs1.loadData();
//		System.out.println(bs1);

		BookShop bs1 = (BookShop) bs.clone();
		bs.getBooks().remove(2);
		bs1.setShopName("A1");
		System.out.println(bs);
		System.out.println(bs1);

	}

}
