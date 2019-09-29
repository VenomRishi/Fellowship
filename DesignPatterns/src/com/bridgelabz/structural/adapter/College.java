package com.bridgelabz.structural.adapter;

public class College {
	public static void main(String a[]) {

		Pen p = new PenAdapter();
		AssignementWork aw = new AssignementWork();
		aw.setPen(p);
		aw.writeAssignement("tired of writing");
	}
}
