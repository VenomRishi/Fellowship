/******************************************************************************
 *  Purpose: Program is written for design pattern of Singleton Eager
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.singleton.eager;

public class EagerMain {

	public static void main(String[] args) {
		EagerInstanceSingleton e1 = EagerInstanceSingleton.getInstance();
		EagerInstanceSingleton e2 = EagerInstanceSingleton.getInstance();
		System.out.println(e1);
		System.out.println(e2);

	}

}
