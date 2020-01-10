package set;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
public static void main(String[] args) {
	
	LinkedHashSet<Object> h=new LinkedHashSet<Object>();
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
