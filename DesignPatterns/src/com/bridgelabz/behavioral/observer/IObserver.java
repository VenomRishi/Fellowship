/******************************************************************************
 *  Purpose: Interface for Observer
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.behavioral.observer;

public interface IObserver {
	// method to update the observer, used by subject
	public void update();

	// attach with subject to observe
	public void setSubject(ISubject sub);
}
