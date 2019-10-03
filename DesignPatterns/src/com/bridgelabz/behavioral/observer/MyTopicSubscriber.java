/******************************************************************************
 *  Purpose: Implementation of Observer and this class also tells the
 *  		 subscriber details
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.behavioral.observer;

public class MyTopicSubscriber implements IObserver {
	private String name;
	private ISubject topic;

	public MyTopicSubscriber(String nm) {
		this.name = nm;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if (msg == null) {
			System.out.println(name + ":: No new message");
		} else
			System.out.println(name + ":: Consuming message::" + msg);
	}

	@Override
	public void setSubject(ISubject sub) {
		this.topic = sub;
	}
}
