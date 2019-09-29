package com.bridgelabz.structural.adapter;

public class AssignementWork {
	private Pen pen;

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}

	public void writeAssignement(String str) {
		pen.write(str);
	}
}
