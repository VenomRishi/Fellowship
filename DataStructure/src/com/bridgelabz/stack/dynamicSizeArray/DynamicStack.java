package com.bridgelabz.stack.dynamicSizeArray;

public class DynamicStack {
	int capacity = 2;
	int stack[] = new int[capacity];
	int top = 0;

	public void push(int data) {
		if (size() == capacity)
			expand();

		stack[top] = data;
		top++;

	}

	private void expand() {
		int[] newStack = new int[capacity * 2];
		for (int i = 0; i < stack.length; i++) {
			newStack[i] = stack[i];
		}
		stack = newStack;
		capacity *= 2;

	}

	public int pop() {
		int data=0;
		if(isEmpty()) {
			System.out.println("Stack is underflow");
		}else {
			top--;
			data = stack[top];
			stack[top] = 0;
			shrink();
			return data;
		}
		
		return data;

	}

	private void shrink() {
		int length = size();
		if (length <= (capacity / 2) / 2)// 1/4
			capacity = capacity / 2;// 1/2
		int[] newStack = new int[capacity];

		// for copying one array (stack) to another array (newStack)
		/*
		 * System.arraycopy(stack,0,newStack,0,length);
		 */
		for (int i = 0; i < newStack.length; i++) {
			newStack[i] = stack[i];
		}
		stack = newStack;

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
		return top == stack.length;
	}

	public boolean isEmpty() {
		return top == 0;
	}
}
