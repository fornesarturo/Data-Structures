package linearList;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DLinkedList<Item> implements LinearList<Item>{
	private DNode<Item> firstNode, lastNode;
	private int size;
	
	public DLinkedList(){
		this.size = 0;
		this.firstNode = null;
		this.lastNode = null;
	}

	public boolean isEmpty() {
		return(size == 0);
	}

	public int size() {
		return this.size;
	}

	public Item get(int index) {
		DNode<Item> temp;
		if(index < 0 || index > this.size-1){
			throw new IndexOutOfBoundsException("Index out of range");
		}
		temp = getNode(index);
		return temp.element;
	}
	
	private DNode<Item> getNode(int index){
		DNode<Item> temp = firstNode;
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		return temp;
	}
	
	public void addFirst(Item item){
		DNode<Item> temp = this.firstNode;
		DNode<Item> newNode = new DNode<Item>(null, item, this.firstNode);
		this.firstNode = newNode;
		if(this.size == 0){
			this.lastNode = newNode;
		}
		else{
			temp.prev = newNode;
		}
		this.size++;
	}
	
	public void addLast(Item item){
		DNode<Item> newNode = new DNode<Item>(this.lastNode, item, null);
		if(this.size == 0){
			this.firstNode = newNode;
		}
		else{
			this.lastNode.next = newNode;
		}
		this.lastNode = newNode;
		this.size++;
	}

	public int indexOf(Item item) {
		DNode<Item> temp = this.firstNode;
		for(int i = 0; i < this.size; i++) {
			if (temp.element.equals(item)){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}

	public Item remove(int index) {
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("No such index in range");
		}
		DNode<Item> prev = this.firstNode;
		DNode<Item> toRemove;
		if(index == 0){
			toRemove = this.firstNode;
			this.firstNode = this.firstNode.next;
			this.size--;
			return toRemove.element;
		}
		DNode<Item> next;
		prev = getNode(index-1);
		toRemove = prev.next;
		next = toRemove.next;
		prev.next = next;
		if(index == size-1){
			this.lastNode = prev;
		}
		else{
			next.prev = prev;
		}
		this.size--;
		return toRemove.element;
	}

	public void add(int index, Item item) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("No such index in range");
		}
		if (index == 0) {
			this.addFirst(item);
		}
		else if (index == size) {
			this.addLast(item);
		}
		else{
			DNode<Item> prev = firstNode;
			prev = this.getNode(index-1);
			DNode<Item> next = prev.next;
			DNode<Item> toAdd = new DNode<Item>(prev, item, next);
			prev.next = toAdd;
			next.prev = toAdd;
			this.size++;
		}
	}

	public String output() {
		DNode<Item> temp = this.firstNode;
		StringBuilder output = new StringBuilder("{");
		for(int i = 0; i < this.size; i++){
			output.append(temp.element.toString());
			if(i == this.size-1){
				output.append("");
			}
			else{
				output.append(",");
			}
			temp = temp.next;
		}
		output.append("}");
		return output.toString();
	}
	
	public ListItr iterator(){
		return new ListItr();
	}
	
	private static class DNode<Item>{
		protected DNode<Item> prev, next;
		Item element;
		
		@SuppressWarnings("unused")
		public DNode(){
			this(null,null,null);
		}
		
		public DNode(DNode<Item> prev, Item element, DNode<Item> next){
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}
	
	protected class ListItr implements ListIterator<Item>{
		private DNode<Item> lastVisitedNode = null;
		private DNode<Item> next;
		private int nextIndex;
		
		public ListItr(){
			this.next = DLinkedList.this.firstNode;
			this.nextIndex = 0;
		}
		public ListItr(int index){
			if(index == size){
				this.next = null;
			}
			else{
				this.next = DLinkedList.this.getNode(index);
			}
			this.nextIndex = index;
		}
		
		public boolean hasNext(){
			return (nextIndex < DLinkedList.this.size);
		}
		
		public Item next(){
			if(!hasNext()){
				throw new NoSuchElementException("No elements");
			}
			this.lastVisitedNode = this.next;
			this.next = this.next.next;
			this.nextIndex++;
			return lastVisitedNode.element;
		}
		
		public boolean hasPrevious(){
			return (nextIndex > 0);
		}
		
		public Item previous() {
			if(!hasPrevious()){
				throw new NoSuchElementException("No elements");
			}
			if(this.next == null){
				this.next = lastVisitedNode;
			}
			else{
				this.next = this.next.prev;
			}
			this.lastVisitedNode = this.next;
			this.nextIndex--;
			return lastVisitedNode.element;
		}
		
		public int nextIndex() {
			if(!this.hasNext()){
				return DLinkedList.this.size;
			}
			return this.nextIndex;
		}
		
		public int previousIndex() {
			if(!this.hasPrevious()){
				return -1;
			}
			return this.nextIndex-1;
		}
		
		public void remove() {
		}
		
		public void set(Item e) {
		}
		
		public void add(Item e) {
		}
	}
}
