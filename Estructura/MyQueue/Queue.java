package MyQueue;

public interface Queue<Item> {
	public boolean empty();
	public Item front();
	public Item rear();
	public Item dequeue();
	public void enqueue(Item item);
	public int size();
}
