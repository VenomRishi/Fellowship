/******************************************************************************
 *  Purpose: Implementation of Command Executor
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.proxy;

import java.io.IOException;

public class ImplCommandExecutor implements ICommandExecutor {
	@Override
	public void runCommand(String cmd) throws IOException {
		// some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}
}
