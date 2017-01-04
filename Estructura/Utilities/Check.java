package Utilities;

public class Check {
	public static void main(String[] args){
		ChainLinearList<Character> binaryList = new ChainLinearList<Character>();
		binaryList.add(0,'0');
		binaryList.add(0,'1');
		binaryList.add(0,'0');
		binaryList.add(0,'1');
		binaryList.add(0,'0');
		binaryList.add(0,'0');
		binaryList.add(0,'1');
		
		System.out.println(Iterative(binaryList));
		
	}
	public static boolean Iterative(ChainLinearList<Character> zero){
		Stack<Character> one = new Stack<Character>();
		int size = zero.size;
		if(size%2 != 0){
			return false;
		}
		for(int i = 0; i < size; i++){
			if(zero.get(i) == '1'){
				one.push(zero.get(i));
			}
		}
		int noOne = 0;
		while(!one.isEmpty()){
			one.pop();
			noOne++;
		}
		if(noOne == size/2){
			return true;
		}
		return false;
	}
}
