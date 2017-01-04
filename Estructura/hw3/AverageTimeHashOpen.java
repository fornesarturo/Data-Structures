package hw3;

public class AverageTimeHashOpen {
	static long iTime;
	static long fTime;
	static HashTableOpenAddressing<Integer,Integer> cadenita = new HashTableOpenAddressing<Integer,Integer>();
	
	public static void main(String[] args){
		//The method to test is put between the longs for time.
		
		//To add to the lists
		for(int i = 0; i < 10000; i++)
			cadenita.add(i,1);
		
		//Methods to remove
		cadenita.remove(9999);
		
		//Stopwatch-esque thing.
		long iTime = System.nanoTime();
		
		//Put methods here, manually change the sizes and indexes.
		cadenita.clear();
		
		long fTime = System.nanoTime();
		System.out.println((fTime-iTime)/1000000.0);
	}
}
