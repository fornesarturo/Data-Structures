package lab4;

public class QueueMain {
	public static void main(String[] args){
		Queue<Integer> q = new Queue<Integer>();
		try {
			
			q.enqueue(1);
			System.out.println(q.size);
			q.enqueue(2);
			System.out.println(q.size);
			q.enqueue(3);
			System.out.println(q.size);
			q.enqueue(4);
			System.out.println(q.size);
			q.enqueue(5);
			System.out.println(q.size);
			q.enqueue(6);
			System.out.println(q.size);
			q.enqueue(7);
			System.out.println(q.size);
			q.enqueue(8);
			System.out.println(q.size);
			
			
			System.out.println();
			
			System.out.println(q.size);
			System.out.println(q.isEmpty());
			System.out.println(q.dequeue());
			
			System.out.println();
			
			
			System.out.println(q.size);
			System.out.println(q.isEmpty());
			System.out.println(q.dequeue());
			
			System.out.println();
			
			
			System.out.println(q.size);
			System.out.println(q.isEmpty());
			System.out.println(q.dequeue());
			
			System.out.println();
			
	
			
			System.out.println(q.size);
			System.out.println(q.isEmpty());
			System.out.println(q.dequeue());
			
			System.out.println();
			
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
