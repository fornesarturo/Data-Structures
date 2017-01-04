package linearList;

public class DLinkedListMain {
	public static void main(String[] args){
		DLinkedList<Integer> cadenita = new DLinkedList<Integer>();
		try{
			cadenita.addFirst(2);
			System.out.println(cadenita.output());
			cadenita.addLast(4);
			System.out.println(cadenita.output());
			cadenita.addFirst(1);
			System.out.println(cadenita.output());
			
			//Add first.
			cadenita.add(0,0);
			System.out.println(cadenita.output());
			
			//Add last.
			cadenita.add(4,5);
			System.out.println(cadenita.output());
			
			//Add in the middle.
			cadenita.add(3, 3);
			System.out.println(cadenita.output());
			
			//Size
			System.out.println(cadenita.size());
			
			//Remove
			cadenita.remove(5);
			System.out.println(cadenita.output());
			System.out.println(cadenita.size());
			
			System.out.println(cadenita.indexOf(4));
			
			System.out.println(cadenita.get(0));
			
			System.out.println();
			
			//DLinkedList<Integer>.ListItr it = cadenita.new ListItr();
			DLinkedList<Integer>.ListItr it = cadenita.iterator();
			
			while(it.hasNext()){
				System.out.print(it.nextIndex());
				System.out.println(it.next());
			}
			while(it.hasPrevious()){
				System.out.print(it.previousIndex());
				System.out.println(it.previous());
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
