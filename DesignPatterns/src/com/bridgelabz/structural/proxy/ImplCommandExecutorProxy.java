package com.bridgelabz.structural.proxy;

public class ImplCommandExecutorProxy implements ICommandExecutor {
	private boolean isAdmin;
	private ICommandExecutor executor;

	public ImplCommandExecutorProxy(String user, String pwd) {
		if ("admin".equals(user) && "123".equals(pwd))
			isAdmin = true;
		executor = new ImplCommandExecutor();
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			executor.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("rm")) {
				throw new Exception("rm command is not allowed for non-admin users.");
			} else {
				executor.runCommand(cmd);
			}
		}
	}
}
