package MyStack;

import java.util.EmptyStackException;

public class MyScratchStack<T> implements Stack<T>{
	private Node<T> firstNode;
	private int size;

	public MyScratchStack() {
		this.firstNode = null;
		this.size = 0;
	}

	public boolean empty(){
		return size == 0;
	}

	public T peek(){
		if(size == 0){
			throw new EmptyStackException();
		}
		return this.firstNode.element;
	}

	public T pop(){
		if(size == 0){
			throw new EmptyStackException();
		}
		Node<T> toReturn = this.firstNode;
		this.firstNode = firstNode.next;
		this.size--;
		return toReturn.element;
	}

	public void push(T item){
		Node<T> toPush = new Node<T>(item,this.firstNode);
		this.firstNode = toPush;
		this.size++;
	}

	private static class Node<T> {
		protected T element;
		protected Node<T> next;

		public Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
		}
	}
}
