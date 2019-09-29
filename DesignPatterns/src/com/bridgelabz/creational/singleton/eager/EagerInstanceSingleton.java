package com.bridgelabz.creational.singleton.eager;

public class EagerInstanceSingleton {
	public static final EagerInstanceSingleton INSTANCE = new EagerInstanceSingleton();

	public EagerInstanceSingleton() {
	}

	public static EagerInstanceSingleton getInstance() {
		return INSTANCE;
	}
}
