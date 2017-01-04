package Matrix;

import java.util.NoSuchElementException;

public class SparseMatrix<E> {
	protected Node<E>[] start;
	private int rows;
	private int columns;
	private Integer zero = 0;
	
	public SparseMatrix(E[][] element){
		this.rows = element.length;
		this.columns = element[0].length;
		
		this.start = new Node[element.length];

		for(int i = 0; i < element.length; i++){
			for(int j = 0; j < element[i].length;j++){
				if(start[i] == (null)){
					start[i] = new Node<E>(element[i][j],i+1,j+1,null);
				}
				else{
					if(element[i][j] != this.zero){
						Node<E> temp = start[i];
						while(temp.next != (null)){
							temp = temp.next;
						}
						temp.next = new Node<E>(element[i][j],i+1,j+1,null);
					}
				}
			}
		}
	}
	
	private static class Node<E>{
		protected E item;
		@SuppressWarnings("unused")
		protected int i,j;
		protected Node<E> next;
		
		@SuppressWarnings("unused")
		public Node(){
			this(null,0,0,null);
		}
		
		public Node(E item, int i, int j, Node<E> next){
			this.item = item;
			this.i = i;
			this.j = j;
			this.next = next;
		}
	}
	
	public void check(int i, int j){
		if (i < 1 || i > this.rows|| j < 1 || j > this.columns){
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void add(int i, int j, E item){
		check(i,j);
		Node<E> temp = this.start[i-1];
		
		if(temp == (null)){
			temp = new Node<E>(item, i, j, null);
		}
		else{
			while(temp.next != (null) && temp.next.j < j){
				temp = temp.next;
			}
			if(temp.j == j){
				temp.item = item;
			}
			else if(temp.next != null && temp.next.j == j){
				temp.next.item = item;
			}
			else{
				Node<E> toAdd = new Node<E>(item, i, j, temp.next);
				temp.next = toAdd;
			}
		}
	}
	
	public E get(int i, int j){
		check(i,j);
		Node<E> temp = this.start[i-1];
		if(temp == (null)){
			return null;
		}
		else{
			while(temp.next != null && temp.j != j){
				temp = temp.next;
			}
			if(temp.j == j){
				return temp.item;
			}
			else{
				return (E) this.zero;
			}
		}
	}
	
	public E remove(int i, int j){
		check(i,j);
		Node<E> temp = this.start[i-1];
		if(temp == (null)){
			throw new NoSuchElementException();
		}
		else{
			while(temp.next != (null) && temp.j != j){
				temp = temp.next;
			}
			if(temp.j == j){
				E toReturn = temp.item;
				temp.item = (E) this.zero;
				return toReturn;
			}
		}
		return null;
	}
	
	public String output(){
		StringBuilder output = new StringBuilder();
		Node<E> temp;
		int dif;
		for(int i = 0; i < this.rows; i++){
			temp = start[i];
			
			while(temp.next != null){
				output.append(temp.item);
				dif = temp.next.j-temp.j;
				if(dif > 1){
					for(int h=1;h<dif;h++){
						output.append(this.zero);
					}
				}
				temp = temp.next;
			}
			output.append(temp.item);
			if(temp.j != this.columns){
				dif = this.columns-temp.j;
				for(int h=0;h<dif;h++){
					output.append(this.zero);
				}
			}
			
			
			output.append("\n");
		}
		return output.toString();
	}
	
}

