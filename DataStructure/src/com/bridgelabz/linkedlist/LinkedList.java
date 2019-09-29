package com.bridgelabz.linkedlist;

public class LinkedList<T> {
	Node<T> head;

	public void insert(T data) {
		Node<T> new_node = new Node<T>();
		new_node.data = data;
		if (head == null) {
			head = new_node;
		} else {
			Node<T> n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = new_node;
		}
	}

	public void insertAtStart(T data) {
		Node<T> new_node = new Node<T>();
		new_node.data = data;
		new_node.next = null;
		new_node.next = head;
		head = new_node;
	}

	public void insertAt(int index, T data) {
		Node<T> new_node = new Node<T>();
		new_node.data = data;
		new_node.next = null;

		if (index == 0) {
			insertAtStart(data);
		} else {
			Node<T> n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			new_node.next = n.next;
			n.next = new_node;
		}
	}

	public void deleteAtStart() {
		Node<T> n = head;
		head = head.next;
		System.out.println("Node deleted is: " + n.data);
		n = null;
	}

	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> n = head;
			Node<T> n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			System.out.println("Node deleted is: " + n1.data);
			n1 = null;
		}
	}

	public void show() {
		Node<T> n = head;
		while (n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
}
