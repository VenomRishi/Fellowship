package com.bridgelabz.queue.fixedSizeArray;

public class Queue {
	int[] queue = new int[5];
	int front;
	int rear;
	int size;

	public void enQueue(int data) {
		queue[rear] = data;
		rear = (rear + 1) % 5;
		size = size + 1;

		if (isFull()) {
			System.out.println("Queue is full removing first value");
		}
	}

	public int deQueue() {
		int data = queue[front];
		if (!isEmpty()) {

			front = (front + 1) % 5;
			size = size - 1;

		} else {
			System.out.println("Queue is empty nothing to delete");
		}

		return data;

	}

	public void show() {
		System.out.print("Element : ");
		int length = queue.length;
		int count = rear;
		if (isFull()) {
			while (length > 0) {
				System.out.print(queue[count] + " ");
				count++;
				if (count == 5) {
					count = 0;
				}
				length--;
			}
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(queue[(front + i) % 5] + " ");
			}
		}

	}

	public int getSize() {
		return size;
	}

	public boolean isFull() {
		return getSize() == 5;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}
}
