package Utilities;

public class Conversion2 {
	static ArrayLinearList<Character> lista = new ArrayLinearList<Character>();;
	static Stack<Character> stack;
	public static void main(String[] args){
		System.out.println("For the ArrayLinearList:");
		lista.add(0, 'D');
		lista.add(0, 'C');
		lista.add(0, 'B');
		lista.add(0, 'A');
		lista.add(0, '+');
		lista.add(0, '+');
		lista.add(0, '-');
		System.out.println(lista.output());
		System.out.println(Recursive(lista).output());
		System.out.println(lista.output());
		System.out.println();
		lista.clear();
		System.out.println("For the Stack:");
		lista.add(0, 'D');
		lista.add(0, 'C');
		lista.add(0, 'B');
		lista.add(0, 'A');
		lista.add(0, '+');
		lista.add(0, '+');
		lista.add(0, '-');
		System.out.println(lista.output());
		System.out.println(Iterative(lista).output());
		System.out.println(lista.output());
	}
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> list){
		ArrayLinearList<Character> newList = new ArrayLinearList<Character>();
		for(int i = 0; i < list.size(); i++){
			newList.add(i,list.get(i));
		}
		return Recursive(newList,0);
	}
	
	public static ArrayLinearList<Character> Recursive(ArrayLinearList<Character> list,int index){
		if(list.get(0) != '-' && list.get(0) != '+'){
			return list;
		}
		else{
			Character toPut = list.remove(0);
			list.add(list.size(), toPut);
			return Recursive(list,index);
		}
	}	
	
	public static ArrayLinearList<Character> Iterative(ArrayLinearList<Character> lista){
		stack = new Stack<Character>();
		ArrayLinearList<Character> newList = new ArrayLinearList<Character>();
		for(int i = 0; i < lista.size(); i++){
			newList.add(i,lista.get(i));
		}
		int size = newList.size();
		for(int i = size/2-1; i >= 0; i--){
			stack.push(newList.remove(i));
		}
		
		while(!stack.isEmpty()){
			newList.add(newList.size(), stack.pop());
		}
		return newList;
	}
}
