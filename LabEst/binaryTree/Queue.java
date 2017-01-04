package binaryTree;

import java.util.NoSuchElementException;
/**
 * An array implementation of an ADT Queue (First In First Out).
 * @author fornesarturo
 *
 * @param <T> Generic Object type.
 */
public class Queue<T> {
	private T[] element;
	public int size;
	private int defaultCap = 5;
	private int front;
	private int rear;
	/**
	 * Queue() - creates an empty queue with initial capacity 5.
	 */
	public Queue(){
		this.element = (T[]) new Object[this.defaultCap];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	/**
	 * Queue(int c) - creates a Queue with capacity c
	 * @param c - input capacity
	 */
	public Queue(int c){
		this.element = (T[]) new Object[c];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	/**
	 * duplica() - Resizes the array to double its original capacity.
	 */
	private void duplica(){
		int sizeG = this.size;
		T[] newArray = (T[]) new Object[this.element.length*2];
		for(int i = 0; i < this.element.length ; i++){
			newArray[i] = this.dequeue();
		}
		this.front = 0;
		this.rear = this.element.length;
		this.element = newArray;
		this.size = sizeG;
	}
	/**
	 * isEmpty() - returns true if the Queue is empty
	 * @return Boolean true if the size of the Queue is 0 and false otherwise.
	 */
	boolean isEmpty(){
		return (this.size == 0);
	}
	/**
	 * dequeue() - Checks if the Queue is empty, throws an exception if it is. Takes the first element out of the Queue and returns it
	 * @return The first element of the Queue.
	 */
	public T dequeue(){
		if(this.isEmpty()){
			throw new NoSuchElementException("No elements in Queue");
		}
		T toReturn = this.element[this.front];
		this.element[this.front] = null;
		this.front = (this.front+1) % this.element.length;
		this.size--;
		return toReturn;
	}
	/**
	 * enqueue() - inserts an element at the last place. Resizes the Queue if it is at is maximum capacity.
	 * @param item - element to insert
	 */
	public void enqueue(T item){
		if(this.size == this.element.length){
			this.duplica();
		}
		this.element[this.rear] = item;
		this.rear = (this.rear+1)%this.element.length;
		this.size = this.size + 1;
	}
	/**
	 * front() - Gives the front-most element of the Queue.
	 * @return The value at the first place.
	 */
	public T front(){
		if(this.isEmpty()){
			throw new NoSuchElementException("Empty");
		}
		return this.element[this.front];
	}
	/**
	 * rear() - Gives the rear-most element of the Queue.
	 * @return The value at the last place.
	 */
	public T rear(){
		if(this.isEmpty()){
			throw new NoSuchElementException("Empty");
		}
		return this.element[this.rear];
	}
	
}
