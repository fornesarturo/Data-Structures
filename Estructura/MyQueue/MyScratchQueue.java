package MyQueue;

import java.util.NoSuchElementException;

public class MyScratchQueue<E> implements Queue<E>{
	private int size;
	private Node<E> front,rear;
	
	public MyScratchQueue(){
		this.front = this.rear = null;
		this.size = 0;
	}

	public boolean empty() {
		return this.size == 0;
	}

	public E front() {
		if(this.front == null)
			return null;
		return this.front.item;
	}

	public E rear() {
		if(this.rear == null)
			return null;
		return this.rear.item;
	}

	public E dequeue() {
		if(this.front == null){
			return null;
		}
		if(this.size() == 0){
			throw new NoSuchElementException();
		}
		Node<E> toReturn = this.front;
		if(this.front.equals(this.rear)){
			this.rear = null;
		}
		this.front = this.front.next;
		this.size--;
		return toReturn.item;
	}

	public void enqueue(E item) {
		if(this.front == null){
			this.front = new Node<E>(item);
			this.size++;
		}
		else if(this.rear == null){
			this.rear = new Node<E>(item);
			this.front.next = this.rear;
			this.size++;
		}
		else{
			this.rear.next = new Node<E>(item);
			this.rear = this.rear.next;
			this.size++;
		}
		
	}

	public int size() {
		return this.size;
	}
	
	private class Node<Item>{
		Item item;
		Node<Item> next;
		Node(Item item){
			this.item = item;
		}
	}
	
}
