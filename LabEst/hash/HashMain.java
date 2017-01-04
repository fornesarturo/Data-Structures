package hash;

import java.util.Iterator;

public class HashMain {
	public static void main(String[] args){
		HashT<String,Integer> h = new HashT<String,Integer>(2);
		
		h.add("Hola", 10);
		h.add("Adios", 11);
		h.add("Que tal", 12);
		h.add("Saludos", 13);
		h.add("Que pedo", 14);
		System.out.println(h.getSize());
		System.out.println(h.remove("Hola"));
		System.out.println(h.getValue("Que pedo"));
		
		Iterator<String> valIt = h.getKeyIterator();
		
		System.out.println(valIt.next());
		System.out.println(valIt.next());
		System.out.println(valIt.next());
		System.out.println(valIt.hasNext());
		System.out.println(h.getSize());
		System.out.println();
		
		h.clear();
		System.out.println(h.getSize());
		h.add("Bye", 10);
		h.add("Hello", 11);
		h.add("Greetings", 12);
		h.add("Sup", 13);
		h.add("Boy", 14);
		System.out.println(h.remove("Sup"));
		
		Iterator<String> keyIt = h.getKeyIterator();
		
		System.out.println(keyIt.next());
		System.out.println(keyIt.next());
		System.out.println(keyIt.next());
		System.out.println(keyIt.next());
		System.out.println(keyIt.hasNext());
		System.out.println(h.getSize());
		
		
	}
}
