package hw2;

public class AverageTimeChainArray {
	static long iTime;
	static long fTime;
	static ArrayLinearList<Integer> myList = new ArrayLinearList<Integer>();
	static ChainLinearList<Integer> cadenita = new ChainLinearList<Integer>();
	
	public static void main(String[] args){
		//The method to test is put between the longs for time.
		
		//To fill the lists
		for(int i = 0; i < 10000; i++)
			cadenita.add(0,1);
		for(int i = 0; i < 10000; i++)
			myList.add(0, 1);
		
		//To add to the lists
		for(int i = 0; i < 10000; i++)
			cadenita.add(i,1);
		for(int i = 0; i < 10000; i++)
			myList.add(0,1);
		
		//Methods to remove
		cadenita.remove(9999);
		myList.remove(0);
		
		//Stopwatch-esque thing.
		long iTime = System.nanoTime();
		
		//Put methods here, manually change the sizes and indexes.
		
		long fTime = System.nanoTime();
		System.out.println((fTime-iTime)/1000000.0);
	}
}
