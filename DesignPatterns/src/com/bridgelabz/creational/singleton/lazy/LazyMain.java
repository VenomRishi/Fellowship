package com.bridgelabz.creational.singleton.lazy;

public class LazyMain {
	public static void main(String a[]) {
		LazyInitializedSingleton e1 = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton e2 = LazyInitializedSingleton.getInstance();
		System.out.println(e1);
		System.out.println(e2);
	}
}
