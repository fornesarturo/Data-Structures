package hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implementation of the DictionaryInterface using Chain.
 * @author fornesarturo
 * @param <K> Key
 * @param <V> Value
 */
public class HashT<K,V> implements DictionaryInterface<K,V>{
	private int m;
	private int size;
	private Node<K,V>[] table;
	private static final int DEFAULT_CAPACITY = 101;
	private static final double DEFAULT_CHARGE = 0.75;
	/**
	 * Creates a Hash Table using the Default Capacity.
	 */
	public HashT(){
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Creates a Hash Table using the given capacity.
	 * @param m - The capacity of the Hash Table.
	 */
	public HashT(int m){
		this.m = m;
		this.size = 0;
		this.table = new Node[m];
	}
	
	/**
	 * Returns an integer that represents the key.
	 * @param key - The key of the Key,Value pair.
	 * @return An unique integer representation of the key.
	 */
	private int hash(K key){
		return (key.hashCode() & 0x7FFFFFFF) % m;
	}
	
	/**
	 * Adds a Key,Value pair to the Hash Table,
	 * if there's already a value associated with
	 * that key, the method will return the previous
	 * value.
	 * @param k - The key of the Key,Value pair.
	 * @param item - The value of the Key,Value pair.
	 * @return The previous value associated with the
	 * key if there was one.
	 */
	public V add(K k, V item) {
		if(this.size >= this.m-1 || (this.size+0.0)/(this.m) >= DEFAULT_CHARGE){
			this.rehash();
		}
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
	
	/**
	 * Removes the Key,Value pair and returns the
	 * Value that's associated with the given Key.
	 * If there's no such key, the method returns null.
	 * @param k - The key whose value will be returned.
	 * @return The value associated with the given key,
	 * if there's no such key in the Hash Table, the returned value
	 * is null.
	 */
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
	/**
	 * Return the Value associated with the given key.
	 * @param k - The Key whose associated value will be
	 * returned.
	 * @return The Value associated with the given key, null
	 * if there's no such key.
	 */
	public V getValue(K k) {
		int h = this.hash(k);
		for(Node<K,V> n = this.table[h]; n != null; n = n.next){
			if(n.key.equals(k)){
				return n.value;
			}
		}
		return null;
	}
	/**
	 * Returns the boolean that represents whether
	 * the key is in the Hash Table or not.
	 * @return True if the key is in the Hash Table,
	 * false otherwise.
	 */
	public boolean contains(K k) {
		return this.getValue(k) != null;
	}
	/**
	 * Returns an instance of an Iterator iterating through
	 * the key-set.
	 * @return An instance of a Key Iterator.
	 */
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}
	/**
	 * Returns an instance of an Iterator iterating through
	 * the value-set.
	 * @return An instance of a Value Iterator.
	 */
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}
	/**
	 * Returns a boolean representing whether
	 * the Hash Table is empty or not.
	 * @return True if the Hash Table has size
	 * zero, false otherwise.
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	/**
	 * Returns the size of the Hash Table.
	 * @return The number of elements in the Hash Table.
	 */
	public int getSize() {
		return this.size;
	}
	/**
	 * Empties out the Hash Table, turning every value into null;
	 */
	public void clear() {
		for(int i = 0; i < this.m; i++){
			this.table[i] = null;
		}
		this.size = 0;
	}
	/**
	 * Doubles the capacity of the Hash Table and rehashes
	 * the keys to a new position based on the new capacity.
	 */
	private void rehash(){
		Iterator<Node<K,V>> nodes = new NodeIterator();
		this.size = 0;
		this.m = m*2;
		this.table = new Node[m];
		
		while(nodes.hasNext()){
			Node<K,V> temp = nodes.next();
			this.add(temp.key, temp.value);
		}
		
	}
	/**
	 * An abstract class that will partly model the functioning
	 * of an iterator through the Hash Table.
	 * @author fornesarturo
	 *
	 * @param <E> The type that will be iterated through.
	 */
	private abstract class HashIterator<E> implements Iterator<E>{
		Queue<Node<K,V>> queue;
		/**
		 * If the number of elements in the Hash Table is greater than 0,
		 * the nodes() method is called, generating a Queue of the nodes
		 * in the Hash Table.
		 */
		public HashIterator(){
			if(HashT.this.size > 0){
				this.queue = this.nodes();
			}
		}
		public boolean hasNext() {
			return queue.peek() != null;
		}
		/**
		 * Returns the following node to be iterated through.
		 * @return The first element of the Queue of Nodes.
		 */
		public Node<K,V> nextNode(){
			if(!this.hasNext()){
				throw new NoSuchElementException();
			}
			return this.queue.poll();
		}
		/**
		 * Returns the whole set of nodes in the Hash Table.
		 * @return A queue which contains the nodes in the Hash Table.
		 */
		private Queue<Node<K,V>> nodes(){
			Queue<Node<K,V>> queue = new LinkedList<Node<K,V>>();
			
			for(Node<K,V> node:HashT.this.table){
				while(node != null){
					queue.add(node);
					node = node.next;
				}
			}
			return queue;
		}
	}
	/**
	 * An iterator that'll iterate through the Nodes
	 * @author fornesarturo
	 *
	 */
	private class NodeIterator extends HashIterator<Node<K,V>>{
		/**
		 * If the number of elements in the Hash Table is greater than 0,
		 * the nodes() method is called, generating a Queue of the nodes
		 * in the Hash Table.
		 */
		public NodeIterator(){
			super();
		}
		public Node<K, V> next() {
			return this.nextNode();
		}
		
	}
	/**
	 * An iterator that'll iterate through the key set of the the Hash Table.
	 * @author fornesarturo
	 *
	 */
	private class KeyIterator extends HashIterator<K>{
		/**
		 * If the number of elements in the Hash Table is greater than 0,
		 * the nodes() method is called, generating a Queue of the nodes
		 * in the Hash Table.
		 */
		public KeyIterator(){
			super();
		}
		public K next() {
			return (K) this.nextNode().key;
		}
	}
	/**
	 * An iterator that'll iterate through the values of the Key,Value pairs of the the Hash Table.
	 * @author fornesarturo
	 *
	 */
	private class ValueIterator extends HashIterator<V>{
		/**
		 * If the number of elements in the Hash Table is greater than 0,
		 * the nodes() method is called, generating a Queue of the nodes
		 * in the Hash Table.
		 */
		public ValueIterator(){
			super();
		}
		public V next() {
			return (V) this.nextNode().value;
		}
	}
	/**
	 * The Nodes of which the Hash Table will consist,
	 * the node represents the Key,Value pair.
	 * @author fornesarturo
	 *
	 * @param <K> - The type that the key will be.
	 * @param <V> - The type that the value will be.
	 */
	private static class Node<K,V>{
		K key;
		V value;
		Node<K,V> next;
		/**
		 * Creates a Node as a Key,Value pair
		 * @param key - The key that'll represent this Key,Value pair
		 * @param value - The value that'll be associated with the key.
		 * @param next - The next node in the bucket, in case of collision.
		 */
		private Node(K key, V value, Node<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
