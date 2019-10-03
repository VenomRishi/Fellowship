/******************************************************************************
 *  Purpose: Program is written for design pattern of Singleton Eager
 *  		 instance of class
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.singleton.eager;

public class EagerInstanceSingleton {
	public static final EagerInstanceSingleton INSTANCE = new EagerInstanceSingleton();

	public EagerInstanceSingleton() {
	}

	public static EagerInstanceSingleton getInstance() {
		return INSTANCE;
	}
}
