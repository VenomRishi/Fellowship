package com.bridgelabz.creational.singleton.staticblock;


public class StaticMain {

	public static void main(String[] args) {
		StaticBlockSingleton e1 = StaticBlockSingleton.getInstance();
		StaticBlockSingleton e2 = StaticBlockSingleton.getInstance();
		System.out.println(e1);
		System.out.println(e2);

	}

}
