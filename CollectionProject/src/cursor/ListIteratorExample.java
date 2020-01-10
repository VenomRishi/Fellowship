package cursor;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorExample {
	public static void main(String[] args) {
		LinkedList<Object> l = new LinkedList<Object>();
		l.add("mark");
		l.add("abhi");
		l.add("vishnu");
		l.add("nag");
		System.out.println(l);
		ListIterator<Object> itr = l.listIterator();
		while (itr.hasNext()) {
			String object = (String) itr.next();
			if (object.equals("mark")) {
				itr.remove();
			} else if (object.equals("nag")) {
				itr.add("chaitu");
			} else if(object.equals("vishnu")) {
				itr.set("charan");
			}
		}
		System.out.println(l);
	}
}
