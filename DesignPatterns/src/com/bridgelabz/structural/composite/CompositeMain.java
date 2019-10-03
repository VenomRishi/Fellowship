/******************************************************************************
 *  Purpose: Program is written for design pattern of Composite
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.composite;

public class CompositeMain {

	public static void main(String[] args) {
		Component hd = new Leaf(4000, "hard drive");
		Component mouse = new Leaf(500, "Mouse");
		Component monitor = new Leaf(8000, "Monitor");
		Component ram = new Leaf(3500, "Ram");
		Component cpu = new Leaf(12000, "CPU");

		Composite ph = new Composite("peripheral");
		Composite cabinet = new Composite("cabinet");
		Composite mb = new Composite("mother board");
		Composite computer = new Composite("Computer");

		mb.addComponent(cpu);
		mb.addComponent(ram);

		ph.addComponent(mouse);
		ph.addComponent(monitor);
		cabinet.addComponent(hd);
		cabinet.addComponent(mb);

		computer.addComponent(ph);
		computer.addComponent(cabinet);
		
		computer.showPrice();
	}

}
