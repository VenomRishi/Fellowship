package com.bridgelabz.creational.factoryphone;

public class FactoryMain {

	public static void main(String[] args) {
		OperatingSystemFactory operatingSystemFactory=new OperatingSystemFactory();
		OS obj=operatingSystemFactory.getInstance("asda");
		obj.spec();
	}

}
