package list;

import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		Vector<Object> v =new Vector<Object>(10,5);
		System.out.println(v.capacity());
		for (int i = 1; i <= 10; i++) {
			v.addElement(i);
		}
		System.out.println(v.capacity());
		v.add("A");
		System.out.println(v.capacity());
		System.out.println(v);
	}
}
