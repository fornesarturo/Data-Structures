package Utilities;

public class Evaluation {
	
	public static void main(String[] args){
		ChainLinearList<Character> list = new ChainLinearList<Character>();
		System.out.println("For the ArrayLinearList:");
		list.add(0, '9');
		list.add(0, '4');
		list.add(0, '3');
		list.add(0, '2');
		list.add(0, '1');
		list.add(0, '-');
		list.add(0, '+');
		list.add(0, '+');
		list.add(0, '-');
		list.add(0, '-');
		System.out.println(list.output());
		System.out.println("Iterative: "+Iterative(list));
		System.out.println("Recursive: "+Recursive(list));
		System.out.println(list.output());
	}
	
	public static int Recursive(ChainLinearList<Character> lista){
		int accum = 0;
		int half = lista.size()/2;
		ChainLinearList<Character> simbolos = new ChainLinearList<Character>();
		ChainLinearList<Character> safeList = new ChainLinearList<Character>();
		
		for(int i = 0; i < lista.size(); i++){
			safeList.add(i,lista.get(i));
		}
		
		for(int i = 0;i < half;i++){
			simbolos.add(i,safeList.remove(0));
		}
		return Recursive(safeList,simbolos,accum);
	}
	
	public static int Recursive(ChainLinearList<Character> numeros,ChainLinearList<Character> signos,int accum){
		if(signos.isEmpty()){
			if(!numeros.isEmpty()){
				return accum+Character.getNumericValue(numeros.remove(numeros.size()-1));
			}
		}
		else{
			if(signos.remove(0) == '+'){
				accum+=Character.getNumericValue(numeros.remove(numeros.size()-1));
				return Recursive(numeros,signos,accum);
			}
			else{
				accum-=Character.getNumericValue(numeros.remove(numeros.size()-1));
				return Recursive(numeros,signos,accum);
			}
		}
		return accum;
	}
	
	public static int Iterative(ChainLinearList<Character> lista){
		Stack<Character> stackS = new Stack<Character>();
		Stack<Character> stackN = new Stack<Character>();
		int limit = lista.size()/2-1;
		
		for(int i = limit; i >= 0;i--){
			stackS.push(lista.get(i));
		}
		for(int i = limit+1; i < lista.size(); i++){
			stackN.push(lista.get(i));
		}
		int accum = 0;
		while(!stackS.isEmpty()){
			if(stackS.pop() == '+'){
				accum+=(Character.getNumericValue(stackN.pop()));
			}
			else{
				accum-=(Character.getNumericValue(stackN.pop()));
			}
		}
		if(!stackN.isEmpty()){
			accum+=(Character.getNumericValue(stackN.pop()));
		}
		return accum;
	}
}
