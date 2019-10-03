/******************************************************************************
 *  Purpose: Class can serve the request upon the OS require
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.creational.factoryphone;

public class OperatingSystemFactory {

	public OS getInstance(String str) {
		if (str.equals("Open"))
			return new Android();
		else if (str.equals("Closed"))
			return new IOS();
		else
			return new Windows();
	}
}
