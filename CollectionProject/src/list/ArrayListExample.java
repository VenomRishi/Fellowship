package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		System.out.println("Array List Example");
		List<Object> al = new ArrayList<Object>();
		List<Object> al2 = new ArrayList<Object>();
		al.add("A");
		al.add(0, 10);
		al.add("A");
		al.add(null);
		System.out.println(al);
		al.remove(2);
		System.out.println(al);
		al.add(2,"M");
		al.add("N");
		al.add("A");
		System.out.println(al);
		al.remove("A");
		System.out.println(al);
		al2.add("A");
		al2.add("M");
		al.removeAll(al2);
		System.out.println(al);
		al.addAll(al2);
		System.out.println(al);
		al.retainAll(al2);
		System.out.println(al);
		
		System.out.println(al.contains("A"));
		
	}
}
