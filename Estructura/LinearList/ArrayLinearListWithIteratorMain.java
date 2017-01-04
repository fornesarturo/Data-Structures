package LinearList;

public class ArrayLinearListWithIteratorMain {
	public static void main(String[] args){
		ArrayLinearListWithIterator<Integer> myList = 
				new ArrayLinearListWithIterator<Integer>();
		
		ArrayLinearListWithIterator<Integer>.IteratorForArrayList scan = 
				myList.new IteratorForArrayList();
		try{
			myList.add(0, 3);
			myList.add(0, 1);
			myList.add(2, 4);
			myList.add(1, 2);
			System.out.println(myList.output());
			
			System.out.println(scan.hasNext());
			System.out.println(scan.next());
			System.out.println(scan.next());
			System.out.println(scan.next());
			scan.remove();
			
			System.out.println(scan.next());
			System.out.println(myList.output());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
