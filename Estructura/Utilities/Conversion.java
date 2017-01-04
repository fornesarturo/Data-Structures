package Utilities;

public class Conversion {
	public static void main(String[] args){
		ArrayLinearList<Character> prefix = new ArrayLinearList<Character>();
		ArrayLinearList<Character> infix = new ArrayLinearList<Character>();
		
		String prefixS = "-++WXYZ";
		String infixS = "W+X+Y-Z";
		
		for(int i = 0; i < prefixS.length(); i++){
			prefix.add(i, prefixS.charAt(i));
			infix.add(i, infixS.charAt(i));
		}
		System.out.println(Recursive(prefix,infix).output());
		System.out.println(Iterative(prefix,infix).output());
	}
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> prefix, ArrayLinearList<Character> infix){
		ArrayLinearList<Character> postfix = new ArrayLinearList<Character>();
		ArrayLinearList<Character> prefixTemp = new ArrayLinearList<Character>();
		ArrayLinearList<Character> infixTemp = new ArrayLinearList<Character>();
		for(int i = 0; i < prefix.size(); i++){
			prefixTemp.add(i, prefix.get(i));
		}
		for(int i = 0; i < prefix.size(); i++){
			infixTemp.add(i, infix.get(i));
		}
		return Recursive(prefixTemp, infixTemp, postfix);
	}
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> prefix, ArrayLinearList<Character> infix, ArrayLinearList<Character> postfix){
		if(infix.size() == 0){
			return postfix;
		}
		char prefixVal = prefix.remove(0);
		int index = infix.size()-1;
		while(index > 0 && infix.get(index) != prefixVal){
			index--;
		}
		if(infix.get(index) == '+' || infix.get(index) == '-'){
			postfix.add(0, infix.remove(index));
			postfix.add(0, infix.remove(index));
		}
		else{
			postfix.add(0, infix.remove(index));
		}
		return Recursive(prefix, infix, postfix);
	}
	
	public static ArrayLinearList<Character> Iterative(ArrayLinearList<Character> prefix, ArrayLinearList<Character> infix){
		Stack<Character> stack = new Stack<Character>();
		ArrayLinearList<Character> postfix = new ArrayLinearList<Character>();
		
		for(int i = 0; prefix.get(i) == '+' || prefix.get(i) == '-'; i++){
			stack.push(prefix.get(i));
		}
		int index = 0;
		
		while(index < infix.size()){
			if(infix.get(index) == '+' || infix.get(index) == '-'){
				postfix.add(postfix.size(), infix.get(index+1));
				postfix.add(postfix.size(), stack.pop());
				index++;
			}
			else{
				postfix.add(postfix.size(),infix.get(index));
			}
			index++;
		}
		return postfix;
	}
}
