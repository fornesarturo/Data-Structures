package myspace;
//It is done
public class Fibonacci {
	public static void main(String[] args){
		for(int i = 0; i <= 10; i++){
			System.out.println(fib(i));
		}
		
	}
	
	public static int fib(int n){
		n++;
		int[] array = {0,1};
		if(n == 0){
			return -1;
		}
		if(n%2 == 0){
			array[0] = 1;
			array[1] = 0;
		}
		while(n > 1){
			array[n%2] = array[0]+array[1];
			n--;
		}
		return array[0];
	}
}
