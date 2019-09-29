package com.bridgelabz.creational.singleton.eager;

public class EagerMain {

	public static void main(String[] args) {
		EagerInstanceSingleton e1 = EagerInstanceSingleton.getInstance();
		EagerInstanceSingleton e2 = EagerInstanceSingleton.getInstance();
		System.out.println(e1);
		System.out.println(e2);

	}

}
