/******************************************************************************
 *  Purpose: Program is written for design pattern of Singleton Enum
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.singleton.enumsingleton;

public class EnumMain {

	public static void main(String[] args) {
		EnumSingleton e1=EnumSingleton.INSTANCE;
		EnumSingleton e2=EnumSingleton.INSTANCE;
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

	}

}
