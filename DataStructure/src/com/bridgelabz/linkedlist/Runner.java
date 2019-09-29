package com.bridgelabz.linkedlist;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list=new LinkedList<>();
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insertAtStart(15);
		list.insertAt(2,55);
		list.show();
		list.deleteAt(2);
		list.deleteAtStart();
		list.show();
	}

}
