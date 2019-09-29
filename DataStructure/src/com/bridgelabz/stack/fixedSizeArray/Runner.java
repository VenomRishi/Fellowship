package com.bridgelabz.stack.fixedSizeArray;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		System.out.println(stack.peek() + "peek");
		stack.push(30);
		stack.show();

		System.out.println("\n" + stack.pop() + "pop");

		System.out.println("\n" + stack.pop() + "pop");
		stack.push(10);
		stack.push(20);
		stack.push(10);
		stack.push(20);
		stack.push(10);
		stack.push(20);
		stack.pop();
		stack.show();
	}

}
