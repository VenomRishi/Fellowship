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
