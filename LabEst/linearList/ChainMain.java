package linearList;

public class ChainMain {
	public static void main(String[] args){
		Chain<Integer> cadenita = new Chain<Integer>();
		try{
			cadenita.add(0, 3);
			cadenita.add(0, 1);
			cadenita.add(2, 4);
			cadenita.add(2, 7);
			cadenita.add(1, 2);
			
			System.out.println(cadenita.get(0));
			System.out.println(cadenita.get(1));
			System.out.println(cadenita.get(2));
			System.out.println(cadenita.get(3));
			
			System.out.println("Size is: "+cadenita.size());
			
			System.out.println(cadenita.output());
			
			System.out.println();
			System.out.println("Removed: "+cadenita.remove(3));
			System.out.println(cadenita.output());
			System.out.println("Size is: "+cadenita.size());
			
			System.out.println();
			System.out.println("Removed: "+cadenita.remove(0));
			System.out.println(cadenita.output());
			System.out.println("Size is: "+cadenita.size());
			
			System.out.println();
			System.out.println("Removed: "+cadenita.remove(2));
			System.out.println(cadenita.output());
			System.out.println("Size is: "+cadenita.size());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}

