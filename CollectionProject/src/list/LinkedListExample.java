package list;

import java.util.LinkedList;


public class LinkedListExample {
	public static void main(String[] args) {
		LinkedList<Object> l = new LinkedList<Object>();
		l.add("A");
		l.add(30);
		l.add(null);
		l.add("A");
		l.set(0, "Soft");
		l.add(0, "C");
		l.removeLast();
		l.addFirst("CCC");
		System.out.println(l);
	}
}
