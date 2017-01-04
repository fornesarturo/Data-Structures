package linearList;

public class MainChain {
	public static void main(String[] args){
		Chain<Integer> cadenita = new Chain<Integer>();
		try{
			cadenita.add(0, 1);
			cadenita.add(1, 3);
			cadenita.add(1, 2);
			cadenita.add(3, 4);
			
			System.out.println(cadenita.get(0));
			System.out.println(cadenita.get(1));
			System.out.println(cadenita.get(2));
			System.out.println(cadenita.get(3));
			
			System.out.println(cadenita.size());
			
			System.out.println(cadenita.output());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
