package firstMidterm;

public class Sorting{
	
	public static void main(String[] args){
		Chain<Integer> cadenita = new Chain<Integer>();
		cadenita.add(0,4);
		cadenita.add(0,3);
		cadenita.add(0,6);
		cadenita.add(0,1);
		
		System.out.println(cadenita.isSorted());
	}
}
