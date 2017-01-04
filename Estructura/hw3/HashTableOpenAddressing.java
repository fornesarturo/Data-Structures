package hw3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTableOpenAddressing <Key,Value> implements DictionaryInterface<Key,Value> {

	private int m;
	private int size;
	private Entry<Key,Value>[] table;
	
	public HashTableOpenAddressing(){
		this(101);
	}
	
	public HashTableOpenAddressing(int capacity){
		this.m = capacity;
		this.size = 0;
		this.table = new Entry[capacity];
	}
	
	private int hash(Key k){
		return (k.hashCode() & 0x7FFFFFFF) % this.m;
	}
	
	private int hash(Key k, int m){
		return (k.hashCode() & 0x7FFFFFFF) % m;
	}
	
	private void resize(){
		Entry<Key,Value>[] newTable = new Entry[this.m*2+1];
		for(int i = 0; i < this.m; i++){
			if(this.table[i] != null){
				newTable[hash(this.table[i].key, this.m*2+1)] = this.table[i];
			}
		}
		this.m = this.m*2+1;
		this.table = newTable;
	}
	
	public Value add(Key k, Value item) {
		if(this.size >= this.m-1 || (this.size+0.0)/(this.m) >= 0.75){
			this.resize();
		}
		int h = this.hash(k);
		for(int i = h, count = 0; count < this.m; i = ++i%this.m, count++){
			if(this.table[i] == null){
				this.table[i] = new Entry<Key,Value>(k,item);
				this.size++;
				break;
			}
			else if(this.table[i].key.equals(k)){
				Value saved = this.table[i].value;
				this.table[i].value = item;
				return saved;
			}
		}
		
		return null;
	}

	public Value remove(Key k) {
		int h = this.hash(k);
		int freeSpace = -1;
		Value saved = null;
		for(int i = h; this.table[i] != null; i = ++i%this.m){
			if(this.table[i].key.equals(k)){
				saved = this.table[i].value;
				this.table[i] = null;
				freeSpace = i;
				this.size--;
			}
			else if(freeSpace != -1 && this.hash(this.table[i].key) == h){
					this.table[freeSpace] = this.table[i];
					this.table[i] = null;
					freeSpace = i;
			}
			
		}
		for(int i = freeSpace; freeSpace != -1; i = ++i%this.m){
			if(i != freeSpace && this.table[i] == null){
				break;
			}
			else if(i == freeSpace && this.table[i] == null){
				continue;
			}
			else if(this.hash(this.table[i].key) < freeSpace){
				this.table[freeSpace] = this.table[i];
				this.table[i] = null;
				freeSpace = i;
				}
		}
		return saved;
	}

	public Value getValue(Key k) {
		int h = this.hash(k);
		for(Entry<Key,Value> n = table[h]; n != null; n = table[++h%this.m]){
			if(n.key.equals(k)){
				return n.value;
			}
		}
		return null;
	}

	public boolean contains(Key k) {
		return this.getValue(k) != null;
	}

	public Iterator<Key> getKeyIterator() {
		return new keyIterator<Key>();
	}

	public Iterator<Value> getValueIterator() {
		return new valueIterator<Value>();
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int getSize() {
		return this.size;
	}

	public void clear() {
		for(int i = 0; i < this.m; i++){
			this.table[i] = null;
		}
	}
	
	private static class Entry<Key,Value>{
		Key key;
		Value value;
		
		private Entry(Key key, Value value){
			this.key = key;
			this.value = value;
		}
	}
	
	//Just for debugging purpose.
	public void output(){
		for(int i = 0; i < this.m; i++){
			if(this.table[i]!=null){
				System.out.print(this.table[i].value+"   ");
			}
			else{
				System.out.print(this.table[i]+"   ");
			}
		}
		System.out.println();
	}
	
	@SuppressWarnings("hiding")
	private class keyIterator<Key> implements Iterator<Key> {
		int index;
		
		private keyIterator(){
			for(this.index = 0; this.index < HashTableOpenAddressing.this.m; this.index++){
				if(HashTableOpenAddressing.this.table[this.index] != null){
					break;
				}
			}
		}
		
		public boolean hasNext() {
			return this.index < HashTableOpenAddressing.this.m;
		}
		
		public Key next() {
			if(!this.hasNext()){
				throw new NoSuchElementException();
			}
			int prevIndex = this.index;
			
			
			
			while(++this.index < HashTableOpenAddressing.this.m 
					&& HashTableOpenAddressing.this.table[this.index] == null);
			
			return (Key) HashTableOpenAddressing.this.table[prevIndex].key;
		}
	}
	
	@SuppressWarnings("hiding")
	private class valueIterator<Value> implements Iterator<Value> {
		int index;
		
		private valueIterator(){
			for(this.index = 0; this.index < HashTableOpenAddressing.this.m; this.index++){
				if(HashTableOpenAddressing.this.table[this.index] != null){
					break;
				}
			}
		}
		
		public boolean hasNext() {
			return this.index < HashTableOpenAddressing.this.m;
		}
		
		public Value next() {
			if(!this.hasNext()){
				throw new NoSuchElementException();
			}
			int prevIndex = this.index;
			while(++this.index < HashTableOpenAddressing.this.m 
					&& HashTableOpenAddressing.this.table[this.index] == null);
			return (Value) HashTableOpenAddressing.this.table[prevIndex].value;
		}
	}
}
