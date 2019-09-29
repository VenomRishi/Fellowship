package com.bridgelabz.creational.builder;

public class Phone {
	private String os;
	private int ram;
	private int storage;
	private String processor;;
	private double screenSize;
	private int battery;

	public Phone(String os, int ram, int storage, String processor, double screenSize, int battery) {
		super();
		this.os = os;
		this.ram = ram;
		this.storage = storage;
		this.processor = processor;
		this.screenSize = screenSize;
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "Phone [os=" + os + ", ram=" + ram + ", storage=" + storage + ", processor=" + processor
				+ ", screenSize=" + screenSize + ", battery=" + battery + "]";
	}
	
	

}
