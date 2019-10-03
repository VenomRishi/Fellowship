/******************************************************************************
 *  Purpose: Program is written for design pattern of factory
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.factoryphone;

public class FactoryMain {

	public static void main(String[] args) {
		OperatingSystemFactory operatingSystemFactory=new OperatingSystemFactory();
		OS obj=operatingSystemFactory.getInstance("asda");
		obj.spec();
	}

}
