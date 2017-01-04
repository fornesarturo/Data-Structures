package hw3;

import java.util.Iterator;

public class HashMain {
	public static void main(String[] args){
		HashTableOpenAddressing<Integer, Integer> hash = 
				new HashTableOpenAddressing<Integer, Integer>(1); //17
//		System.out.println(hash.isEmpty());
//		hash.add(5, 5);
//		System.out.println(hash.getValue(5));
//		hash.add(22, 6);
//		System.out.println(hash.getValue(22));
//		hash.add(39, 2);
//		System.out.println(hash.getValue(39));
//		System.out.println(hash.getSize());
//		System.out.println(hash.contains(5));
//		System.out.println(hash.contains(22));
//		System.out.println(hash.contains(39));
//		System.out.println(hash.contains(56));
//		System.out.println(hash.isEmpty());
//		
//		System.out.println();
//		
//		hash.clear();
//		
//		System.out.println("Took out: "+hash.remove(22));
//		System.out.println(hash.getSize());
//		
//		System.out.println();
//		
//		System.out.println("Took out: "+hash.remove(39));
//		System.out.println(hash.getSize());
//		
//		System.out.println("Took out: "+hash.remove(5));
//		System.out.println(hash.getSize());
		
		hash.add(4, 4);
		hash.add(5, 5);
		hash.add(14, 14);
		hash.add(7, 7);
		
		hash.output();
//		System.out.println(hash.remove(5));
//		System.out.println(hash.remove(14));
//		System.out.println(hash.remove(7));
		
		Iterator<Integer> kit = hash.getKeyIterator();
		while(kit.hasNext()){
			System.out.println(kit.next());
		}
		System.out.println();
		
		System.out.println(hash.remove(5));
		System.out.println(hash.remove(14));
		System.out.println(hash.remove(7));
		System.out.println(hash.remove(4));
	}
}
