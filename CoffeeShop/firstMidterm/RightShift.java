package firstMidterm;

public class RightShift {
	public static int[] array = {1,2,3,4,5,6};
	public static int size = 6;
	
	//O(n);
	public static void rightShift(int[] arr, int shift){
		int[] newArray = new int[arr.length+shift];
		for(int i = 0; i < shift; i++){
			newArray[i] = 0;
		}
		System.arraycopy(arr, 0, newArray, shift, arr.length);
		array = newArray;
	}
	
	public static void remove(int index){
		for(int i = index; i < size-1; i++){
			array[i] = array[i+1];
		}
		array[size-1] = 0;
		size--;
	}
	
	//O(n) | n+n/2
	public static void compress(){
		for(int i = 0; i < size-1/2; i++){
			remove(i+1);
		}
	}
	
	public static void main(String[] args){
		//rightShift(array, 3);
		compress();
		for(int i = 0; i < size; i++){
			System.out.println(array[i]);
		}
	}
	
}
