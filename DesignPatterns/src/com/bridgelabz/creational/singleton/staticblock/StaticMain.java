/******************************************************************************
 *  Purpose: Program is written for design pattern of Singleton static block
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.singleton.staticblock;


public class StaticMain {

	public static void main(String[] args) {
		StaticBlockSingleton e1 = StaticBlockSingleton.getInstance();
		StaticBlockSingleton e2 = StaticBlockSingleton.getInstance();
		System.out.println(e1);
		System.out.println(e2);

	}

}
