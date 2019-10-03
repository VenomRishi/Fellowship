
/******************************************************************************
 *  Purpose: Adapter class of PenAdapter
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.adapterpen;

public class College {
	public static void main(String a[]) {

		Pen p = new PenAdapter();
		AssignementWork aw = new AssignementWork();
		aw.setPen(p);
		aw.writeAssignement("tired of writing");
	}
}
