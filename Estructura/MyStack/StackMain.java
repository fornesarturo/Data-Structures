package MyStack;

public class StackMain {
	public static void main(String[] args){
		MyScratchStack<Integer> s = new MyScratchStack<Integer>();
		MyDerivedStack<Integer> n = new MyDerivedStack<Integer>();
		try{
			s.push(4);
			s.push(3);
			System.out.print(s.peek()+" ");
			System.out.print(s.pop()+" ");
			System.out.print(s.pop()+" ");
			
			s.push(5);
			s.push(4);
			s.push(3);
			s.push(2);
			s.push(1);
			s.push(0);
			for(int i = 0; i < 6; i++){
				System.out.print(s.pop()+" ");
			}
			System.out.println();
			
			n.push(4);
			n.push(3);
			System.out.print(n.peek()+" ");
			System.out.print(n.pop()+" ");
			System.out.print(n.pop()+" ");
			
			n.push(5);
			n.push(4);
			n.push(3);
			n.push(2);
			n.push(1);
			n.push(0);
			for(int i = 0; i < 6; i++){
				System.out.print(n.pop()+" ");
			}
			System.out.println();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
		
}
