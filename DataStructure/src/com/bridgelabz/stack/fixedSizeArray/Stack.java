package com.bridgelabz.stack.fixedSizeArray;

public class Stack {
	int stack[] = new int[5];
	int top = 0;

	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack is overflow");
		}else {
			stack[top] = data;
			top++;
		}
		
	}

	public int pop() {
		int data=0;
		if(isEmpty()) {
			System.out.println("Stack is underflow");
		}else {
			top--;
			data = stack[top];
			stack[top] = 0;
			return data;
		}
		
		return data;
	}

	public int peek() {
		int data;
		data = stack[top - 1];
		return data;
	}

	public void show() {
		for (int num : stack) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public int size() {
		return top;
	}
	
	public boolean isFull() {
		return top==stack.length;
	}
	public boolean isEmpty() {
		return top==0;
	}
}
