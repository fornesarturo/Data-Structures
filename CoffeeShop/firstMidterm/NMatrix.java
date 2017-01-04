package firstMidterm;

public class NMatrix {
	public int[] element;
	public static int n;
	public static int zero = 0;
	
	public NMatrix(int no){
		element = new int[3*no-2];
		for(int i = 0; i < 3*no-2; i++){
			element[i] = i;
		}
		n = no;
	}
	
	public void set(int i, int j, int newValue){
		i--;
		j--;
		if(i == 0){
			element[j] = newValue;
		}
		else if(i == n-1){
			element[n+j] = newValue;
		}
		else if(i == j){
			element[2*n+j-1] = newValue;
		}
	}
	
	public static void main(String[] args){
		NMatrix matricita = new NMatrix(4);
		
		matricita.set(1,2,20);
		matricita.set(4, 3, 21);
		matricita.set(2, 2, 22);
		
		for(int i: matricita.element){
			System.out.println(i);
		}
	}
}
