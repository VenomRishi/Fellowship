/******************************************************************************
 *  Purpose: Interface of Socket Adapter
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.adaptersocket;

public interface ISocketAdapter {
	public Volt get120Volt();

	public Volt get12Volt();

	public Volt get3Volt();
}
