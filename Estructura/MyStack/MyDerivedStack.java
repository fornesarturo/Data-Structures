package MyStack;

import java.util.EmptyStackException;

public class MyDerivedStack<T> extends ChainLinearList<T> implements Stack<T>{
	public MyDerivedStack(){
		super();
	}
	
	public boolean empty(){
		return this.size == 0;
	}
	
	public T peek(){
		if(this.size == 0){
			throw new EmptyStackException();
		}
		return this.get(0);
	}
	
	public T pop(){
		if(this.size == 0){
			throw new EmptyStackException();
		}
		return this.remove(0);
	}
	
	public void push(T item){
		this.add(0, item);
	}
}
