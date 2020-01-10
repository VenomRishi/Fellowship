package set;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {
public static void main(String[] args) {
	SortedSet<Object> h=new TreeSet<>();
	h.add("B");
	h.add("C");
	h.add("D");
	h.add("Z"); 
	h.add(null);
	h.add(10);
	System.out.println(h.add("Z"));
	System.out.println(h);
}
}
