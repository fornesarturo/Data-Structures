package hw2;

import java.util.Iterator;

public class ArrayLinearList <Item> implements LinearList <Item>{
	protected int size;
	protected Item element[];
	protected final static int defaultSize = 100;
	private int OGSize;
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public ArrayLinearList(){
		this.size = 0;
		this.element = (Item[]) new Object[this.defaultSize];
		this.OGSize = 100;
	}
	@SuppressWarnings("unchecked")
	public ArrayLinearList(int newSize){
		this.size = 0;
		this.element = (Item[]) new Object[newSize];
		this.OGSize = newSize;
	}
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	public int size() {
		return this.size;
	}

	public Item get(int index) {
		if(this.size == 0)
			return null;
		else if(index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException("Index out of range");
		return this.element[index];
	}

	public int indexOf(Item item) {
		for(int index = 0; index < this.size; index++){
			if(item.equals(element[index])){
				return index;
			}
		}
		return -1;
	}

	public Item remove(int index) {
		Item value;
		if(index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Index out of range");
		}
		value = this.element[index];
		for(int i = index; i < size-1; i++){
			this.element[i] = this.element[i+1];
		}
		this.element[size-1] = null;
		this.size--;
		return value;
	}

	public void add(int index, Item item) {
		if(this.size == this.OGSize){
			this.resize();
		}
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException("Index out of range");
		}
		else if(index == this.size){
			this.element[size] = item;
		}
		else{
			for(int i = this.size; i > index; i--){
				this.element[i] = this.element[i-1];
			}
			this.element[index] = item;
		}
		this.size++;
	}

	public String output() {
		String output = "{";
		int i = 0;
		while(i < this.size){
			output = (i != this.size-1)?output +
					this.element[i].toString() + ",":output + 
					this.element[i].toString();
			i++;
		}
		output = output + "}";
		return output;
	}
	
	private void resize(){
		@SuppressWarnings("unchecked")
		Item[] resizedArray = (Item[]) new Object[OGSize*2];
		System.arraycopy(this.element, 0, resizedArray, 0, this.size);
		this.element = resizedArray;
		this.OGSize = OGSize*2;
	}

	protected class IteratorArray implements Iterator<Item>{
		private int nextIndex;
		private boolean wasNextCalled;
		
		protected IteratorArray(){
			this.nextIndex = 0;
			this.wasNextCalled = false;
		}
		
		public boolean hasNext() {
			return(this.nextIndex != ArrayLinearList.this.size-1);
		}

		public Item next() {
			this.nextIndex++;
			this.wasNextCalled = true;
			return ArrayLinearList.this.element[this.nextIndex-1];
		}
		
		public void remove(){
			if(this.wasNextCalled){
				this.nextIndex--;
				ArrayLinearList.this.remove(nextIndex);
			}
			else{
				throw new IllegalStateException();
			}
			this.wasNextCalled = false;
		}
	}
}
