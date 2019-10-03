/******************************************************************************
 *  Purpose: Class which is used to provide functionality of socket
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.adaptersocket;

public class Socket {
	public Volt getVolt() {
		return new Volt(120);
	}
}
