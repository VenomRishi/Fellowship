package com.bridgelabz.queue.fixedSizeArray;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q=new Queue();
		q.enQueue(5);
		q.enQueue(2);
		q.enQueue(10);
		
		q.deQueue();
		q.deQueue();
		q.enQueue(6);
		
		q.show();
	}

}
