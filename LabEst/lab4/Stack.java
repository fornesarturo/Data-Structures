package lab4;

import java.util.EmptyStackException;

/**
 * A Linked List representation of an ADT Stack (Last In First Out).
 * @author fornesarturo
 *
 * @param <T> Generic Object type.
 */
public class Stack<T> {
	private Node<T> firstNode;
	private int size;
	
	/**
	 * Stack() - creates an empty Stack.
	 */
	public Stack() {
		this.firstNode = null;
		this.size = 0;
	}
	/**
	 * isEmpty() - returns whether the Stack is empty or not.
	 * @return Boolean true if the Stack is empty, false otherwise.
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	/**
	 * peek() - without removing from the Stack, view the next element to remove.
	 * @return The element on top of the Stack without removing it.
	 */
	public T peek(){
		if(size == 0){
			throw new EmptyStackException();
		}
		return this.firstNode.element;
	}
	/**
	 * pop() - remove and return the top element of the Stack.
	 * @return The element on top of the Stack.
	 */
	
	public T pop(){
		if(size == 0){
			throw new EmptyStackException();
		}
		Node<T> toReturn = this.firstNode;
		this.firstNode = firstNode.next;
		this.size--;
		return toReturn.element;
	}
	/**
	 * push(T item) - add an element on top of the Stack.
	 * @param item The element to add.
	 */
	public void push(T item){
		Node<T> toPush = new Node<T>(item,this.firstNode);
		this.firstNode = toPush;
		this.size++;
	}
	
	/**
	 * Node<T> - a Node of the Chain that will form a Stack.
	 * @author fornesarturo
	 *
	 * @param <T>
	 */
	private static class Node<T> {
		protected T element;
		protected Node<T> next;
		
		/**
		 * Node(T element, Node<T> next) - creates a Node with a value and a pointer to the next node.
		 * @param element The value of Node.
		 * @param next The Node that follows the given Node.
		 */
		public Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
		}
	}
	//Los nodos de enlace simple hacen una mejor implementación, porque sólo se agrega y saca de un lado.
}
