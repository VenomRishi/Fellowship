package com.bridgelabz.creational.builder;

public class Shop {

	public static void main(String[] args) {

		/**
		 * in this program if you don't want to pass any feature then you are not
		 * allowed to remove it you have to pass something in it
		 * 
		 * for tackling this problem we instead using builder pattern
		 * 
		 * create another class PhoneBuilder who will responsible for that
		 */
//		Phone phone = new Phone("android", 8, 64, "snapdragon", 6.8, 5000);
		Phone phone = new PhoneBuilder().setOs("Android").setRam(8).getPhone();
		System.out.println(phone);

	}

}
