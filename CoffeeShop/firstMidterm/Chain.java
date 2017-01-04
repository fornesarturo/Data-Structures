package firstMidterm;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Chain<Item> implements LinearList<Item> {
	
	protected ChainNode<Item> firstNode;
	protected int size;
	
	public Chain(){
		this.size = 0;
		this.firstNode = new ChainNode<Item>();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean isSorted(){
		ChainNode<Item> temp = this.firstNode;
		for(int i = 0; i < this.size-1; i++){
			if (((Comparable) temp.element).compareTo(temp.next.element) > 0){
				return false;
			}
			temp = temp.next;
		}
		return true;
	}
	
	public void append(Item item){
		this.add(this.size,item);
	}
	
	public void makeEmpty(){
		this.firstNode = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return (this.size == 0);
	}

	public int size() {
		return this.size;
	}
	
	public Item get(int index) {
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Index out of range");
		}
		ChainNode<Item> temp = firstNode;
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		return temp.element;
	}

	public int indexOf(Item item){
		ChainNode<Item> temp = firstNode;
		for(int index = 0; index < this.size; index++){
			if(temp.element.equals(item)){
				return index;
			}
			temp = temp.next;
		}
		return -1;
	}

	public Item remove(int index) {
		Item value = null;
		ChainNode<Item> temp = firstNode;
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Index out of range");
		}
		else if(index == 0){
			value = temp.element;
			firstNode = firstNode.next;
			this.size--;
			return value;
		}
		else{
			for(int i = 0; i < index-1; i++){
				temp = temp.next;
			}
			value = temp.next.element;
			temp.next = temp.next.next;
			this.size--;
			return value;
		}
	}

	public void add(int index, Item item) {
		ChainNode<Item> newNode;
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException("Index out of range");
		}
		else if(index == 0){
			newNode = new ChainNode<Item>(item, this.firstNode);
			this.firstNode = newNode;
			
		}
		else{
			ChainNode<Item> prev, nxt;
			prev = this.firstNode;
			for(int i = 0; i < index-1; i++){
				prev = prev.next;
			}
			nxt = prev.next;
			newNode = new ChainNode<Item>(item, nxt);
			prev.next = newNode;
		}
		this.size++;
	}
	
	public String output() {
		String output = "{";
		ChainNode<Item> temp = this.firstNode;
		int i = 0;
		while(i < this.size){
			output = (i != this.size-1)?output +
					temp.element.toString() + ",":output + 
					temp.element.toString();
			temp = temp.next;
			i++;
		}
		output = output + "}";
		return output;
	}
	
	private static class ChainNode<Item> {
		protected Item element;
		protected ChainNode<Item> next;
		
		public ChainNode(){
			this(null,null);
		}
		@SuppressWarnings("unused")
		public ChainNode(Item element){
			this(element,null);
		}
		public ChainNode(Item element, ChainNode<Item> next){
			this.element = element;
			this.next = next;
		}
	}
	
	protected class IteratorThing implements Iterator<Item>{
		private int index;
		private ChainNode<Item> next;
		
		public IteratorThing(){
			this.index = 0;
			this.next = Chain.this.firstNode;
		}
		public boolean hasNext() {
			return(this.index < Chain.this.size);
		}

		public Item next() {
			if(!hasNext()){
				throw new NoSuchElementException("No more elements");
			}
			Item toReturn = next.element;
			this.next = this.next.next;
			this.index++;
			return toReturn;
		}
		
	}
	
}
