package hw2;

public class ChainLinearList<Item> implements LinearList<Item> {
	
	protected ChainNode<Item> firstNode;
	protected int size;
	
	public ChainLinearList(){
		this.size = 0;
		this.firstNode = new ChainNode<Item>();
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
	
}
