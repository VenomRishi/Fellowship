/******************************************************************************
 *  Purpose: Program is written for design pattern of Singleton Bill Pough
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.singleton.billpough;

public class BillPoughMain {
	public static void main(String a[]) {
		BillPughSingleton obj1 = BillPughSingleton.getInstance();
		BillPughSingleton obj2 = BillPughSingleton.getInstance();

		System.out.println(obj1);
		System.out.println(obj2);
	}
}
