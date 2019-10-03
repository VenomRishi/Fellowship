/******************************************************************************
 *  Purpose: This is model class which contains all the getters and setters
 *  		 for phone builder
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.builder;

public class PhoneBuilder {
	/**
	 * use all setters and use PhoneBuilder as return type of that methods
	 */

	private String os;
	private int ram;
	private int storage;
	private String processor;;
	private double screenSize;
	private int battery;

	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}

	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}

	public PhoneBuilder setStorage(int storage) {
		this.storage = storage;
		return this;
	}

	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}

	public PhoneBuilder setScreenSize(double screenSize) {
		this.screenSize = screenSize;
		return this;
	}

	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;
	}

	public Phone getPhone() {
		return new Phone(os, ram, storage, processor, screenSize, battery);
	}

}
