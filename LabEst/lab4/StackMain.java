package lab4;

public class StackMain {
	public static void main(String[] args){
		Stack<Integer> s = new Stack<Integer>();
		try{
			s.push(4);
			s.push(3);
			System.out.println(s.peek());
			System.out.println(s.pop());
			System.out.println(s.pop());
			
			s.push(5);
			s.push(4);
			s.push(3);
			s.push(2);
			s.push(1);
			s.push(0);
			for(int i = 0; i < 6; i++){
				System.out.println(s.pop());
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
		
}
