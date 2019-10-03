/******************************************************************************
 *  Purpose: Program is written for design pattern of Proxy
 *  		 instance of class
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		ICommandExecutor executor = new ImplCommandExecutorProxy("admin", "123");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}

}
