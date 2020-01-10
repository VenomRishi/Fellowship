package cursor;

import java.util.Enumeration;
import java.util.Vector;

public class EnumeratorExample {
public static void main(String[] args) {
	Vector<Integer> v=new Vector<Integer>();
	for (int i = 0; i < 10; i++) {
		v.addElement(i);
	}
	System.out.println(v);
	Enumeration<Integer> e =v.elements();
	while (e.hasMoreElements()) {
		Integer I = (Integer) e.nextElement();
		if(I%2==0) {
			System.out.println(I);
		}else {
			System.out.println(I+"will be removed");
			v.remove(I);
			System.out.println(v);
		}
	}
}
}
