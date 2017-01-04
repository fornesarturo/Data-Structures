package Patients;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyHashTable<K,V> implements DictionaryInterface<K,V>{
	protected int m;
	protected int size;
	protected Node<K,V>[] table;
	private static final int DEFAULT_CAPACITY = 101;
	protected static final double DEFAULT_CHARGE = 0.75;

	public MyHashTable(){
		this(DEFAULT_CAPACITY);
	}
	
	public MyHashTable(int m){
		this.m = m;
		this.size = 0;
		this.table = new Node[m];
	}
	
	protected int hash(K key){
		return (key.hashCode() & 0x7FFFFFFF) % m;
	}
	
	public V add(K k, V item) {
		if(this.size >= this.m-1 || (this.size+0.0)/(this.m) >= DEFAULT_CHARGE)
			this.rehash();
		int h = this.hash(k);
		for(Node<K,V> n = this.table[h]; n != null; n = n.next){
			if(n.key.equals(k)){
				V saved = n.value;
				n.value = item;
				return saved;
			}
		}
		Node<K,V> added = new Node<K,V>(k,item,this.table[h]);
		this.table[h] = added;
		this.size++;
		return null;
	}

	public V remove(K k) {
		int h = this.hash(k);
		Node<K,V> first = this.table[h];
		if(first.key.equals(k)){
			V saved = first.value;
			this.table[h] = first.next;
			this.size--;
			return saved;
		}
		for(Node<K,V> n = first; n.next != null; n=n.next){
			if(n.next.key.equals(k)){
				V chosenOne = n.next.value;
				n.next = n.next.next;
				this.size--;
				return chosenOne;
			}
		}
		return null;
	}

	public V getValue(K k) {
		int h = this.hash(k);
		for(Node<K,V> n = this.table[h]; n != null; n = n.next){
			if(n.key.equals(k)){
				return n.value;
			}
		}
		return null;
	}

	public boolean contains(K k) {
		return this.getValue(k) != null;
	}

	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int getSize() {
		return this.size;
	}

	public void clear() {
		for(int i = 0; i < this.m; i++)
			this.table[i] = null;
		
		this.size = 0;
	}

	protected void rehash(){
		Iterator<Node<K,V>> nodes = new NodeIterator();
		this.size = 0;
		this.m = m*2;
		this.table = new Node[m];
		
		while(nodes.hasNext()){
			Node<K,V> temp = nodes.next();
			this.add(temp.key, temp.value);
		}
		
	}

	private abstract class HashIterator<E> implements Iterator<E>{
		Queue<Node<K,V>> queue;

		public HashIterator(){
			if(MyHashTable.this.size > 0)
				this.queue = this.nodes();
		}
		public boolean hasNext() {
			return queue.peek() != null;
		}

		public Node<K,V> nextNode(){
			if(!this.hasNext())
				throw new NoSuchElementException();
			return this.queue.poll();
		}

		private Queue<Node<K,V>> nodes(){
			Queue<Node<K,V>> queue = new LinkedList<Node<K,V>>();
			
			for(Node<K,V> node:MyHashTable.this.table){
				while(node != null){
					queue.add(node);
					node = node.next;
				}
			}
			return queue;
		}
	}

	private class NodeIterator extends HashIterator<Node<K,V>>{

		public NodeIterator(){
			super();
		}
		public Node<K, V> next() {
			return this.nextNode();
		}
		
	}

	private class KeyIterator extends HashIterator<K>{

		public KeyIterator(){
			super();
		}
		public K next() {
			return (K) this.nextNode().key;
		}
	}

	private class ValueIterator extends HashIterator<V>{

		public ValueIterator(){
			super();
		}
		public V next() {
			return (V) this.nextNode().value;
		}
	}

	static class Node<K,V>{
		K key;
		V value;
		Node<K,V> next;

		Node(K key, V value, Node<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
