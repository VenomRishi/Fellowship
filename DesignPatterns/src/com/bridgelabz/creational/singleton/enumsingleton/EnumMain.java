package com.bridgelabz.creational.singleton.enumsingleton;

public class EnumMain {

	public static void main(String[] args) {
		EnumSingleton e1=EnumSingleton.INSTANCE;
		EnumSingleton e2=EnumSingleton.INSTANCE;
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

	}

}
