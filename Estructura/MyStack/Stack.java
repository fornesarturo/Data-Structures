package MyStack;

public interface Stack<Item> {
	public boolean empty();
	public Item peek();
	public void push(Item item);
	public Item pop();
}
