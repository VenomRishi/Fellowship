/******************************************************************************
 *  Purpose: This class contains getters and setters for for assignment work
 *  		 which uses pen
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.adapterpen;

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
