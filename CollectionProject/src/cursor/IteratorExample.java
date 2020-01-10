package cursor;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			a.add(i);
		}
		System.out.println(a);
		Iterator<Integer> i = a.iterator();
		while (i.hasNext()) {
			Integer i2 = i.next();
			if (i2 % 2 == 0) {
				System.out.println(i2);
			} else {
				i.remove();
			}

		}
		System.out.println(a);
	}
}
