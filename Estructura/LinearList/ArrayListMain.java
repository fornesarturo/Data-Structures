package LinearList;

public class ArrayListMain {
	public static void main(String[] args){
		ArrayLinearList<Integer> lista = new ArrayLinearList<Integer>(2);
		try{
			lista.add(0, 2);
			lista.add(1, 4);
			lista.add(1, 3);
			lista.add(0, 1);
			
			System.out.println(lista.get(0));
			System.out.println(lista.get(1));
			System.out.println(lista.get(2));
			System.out.println(lista.get(3));
			
			System.out.println(lista.size());
			System.out.println(lista.output());
			
			System.out.println(lista.remove(1));
			System.out.println(lista.size());
			
			System.out.println(lista.output());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
