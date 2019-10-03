/******************************************************************************
 *  Purpose: Pen adapter which implements pen
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.adapterpen;

public class PenAdapter implements Pen {
	PilotPen pp = new PilotPen();

	@Override
	public void write(String str) {
		pp.mark(str);

	}

}
