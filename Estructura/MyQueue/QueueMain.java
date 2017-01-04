package MyQueue;

public class QueueMain {
	public static void main(String[] args){
		MyScratchQueue<Integer> q = new MyScratchQueue<Integer>();
		System.out.println(q.size());
		System.out.println(q.empty());
		for(int i = 0; i <= 10; i++){
			q.enqueue(i);
			System.out.println(q.size());
		}
		
		while(!q.empty()){
			System.out.println();
			System.out.print("Item: "+q.dequeue()+"  \t");
			System.out.print("Size: "+q.size()+"  \t");
			System.out.print("Front: "+q.front()+"  \t");
			System.out.print("Rear: "+q.rear()+"  \t");
		}
		
		for(int i = 0; i <= 10; i++){
			q.enqueue(i);
			System.out.println(q.size());
		}
		
		while(!q.empty()){
			System.out.println();
			System.out.print("Item: "+q.dequeue()+"  \t");
			System.out.print("Size: "+q.size()+"  \t");
			System.out.print("Front: "+q.front()+"  \t");
			System.out.print("Rear: "+q.rear()+"  \t");
		}
		
	}
}
