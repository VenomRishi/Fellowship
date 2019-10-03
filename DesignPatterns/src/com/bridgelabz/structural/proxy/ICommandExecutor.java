/******************************************************************************
 *  Purpose: Interface for Command Executor
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   30-09-2019
 *
 ******************************************************************************/

package com.bridgelabz.structural.proxy;

public interface ICommandExecutor {
	public void runCommand(String cmd) throws Exception;
}
