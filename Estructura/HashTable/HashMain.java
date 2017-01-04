package HashTable;

import java.util.Iterator;

public class HashMain {
	public static void main(String[] args){
		MyHashTable<Integer,Integer> h = new MyHashTable<Integer,Integer>(2);
		
		h.add(0, 10);
		h.add(1, 11);
		h.add(2, 12);
		h.add(3, 13);
		h.add(4, 14);
		System.out.println("Size: "+h.getSize());
		System.out.println("Removed: "+h.remove(0));
		System.out.println("Value of [1,11]: "+h.getValue(1));
		
		Iterator<Integer> valIt = h.getKeyIterator();
		System.out.println("----Key Iterator----");
		System.out.println(valIt.next());
		System.out.println(valIt.next());
		System.out.println(valIt.next());
		System.out.println("Has next: "+valIt.hasNext());
		System.out.println("Size: "+h.getSize());
		System.out.println();
		
		h.clear();
		System.out.println("Size after clear: "+h.getSize());
		System.out.println("----Cleared----");
		h.add(0, 10);
		h.add(1, 11);
		h.add(2, 12);
		h.add(3, 13);
		h.add(4, 14);
		System.out.println("Remove [4,14]: "+h.remove(4));
		
		Iterator<Integer> keyIt = h.getValueIterator();
		
		System.out.println(keyIt.next());
		System.out.println(keyIt.next());
		System.out.println(keyIt.next());
		System.out.println(keyIt.next());
		System.out.println("Has next: "+keyIt.hasNext());
		System.out.println("Size: "+h.getSize());
		
		
	}
}
