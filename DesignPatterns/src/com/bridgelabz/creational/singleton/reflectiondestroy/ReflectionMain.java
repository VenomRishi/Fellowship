/******************************************************************************
 *  Purpose: Program is written for design pattern of Singleton Reflection and 
 *  		 destroy
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.singleton.reflectiondestroy;

import java.lang.reflect.Constructor;

import com.bridgelabz.creational.singleton.eager.EagerInstanceSingleton;

public class ReflectionMain {
	public static void main(String a[]) {
		EagerInstanceSingleton instanceOne = EagerInstanceSingleton.getInstance();
		EagerInstanceSingleton instanceTwo = null;
		try {
			@SuppressWarnings("rawtypes")
			Constructor[] constructors = EagerInstanceSingleton.class.getDeclaredConstructors();
			for (@SuppressWarnings("rawtypes")
			Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (EagerInstanceSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}
