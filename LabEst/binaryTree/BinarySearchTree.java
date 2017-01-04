package binaryTree;
/**
 * The Binary Search Tree ADT implemented through the use of nodes.
 * @author fornesarturo
 *
 * @param <K> The key that will represent the "priority" of the Node.
 * @param <V> The value that will be stored in the Node.
 */
public class BinarySearchTree <K extends Comparable<K>,V> {
	/**
	 * The root of the Binary Tree.
	 */
	TreeNode root;
	/**
	 * Creates a new Binary Search Tree with root as null.
	 */
	public BinarySearchTree(){
		this.root = null;
	}
	/**
	 * Returns whether the Tree is empty or not.
	 * @return true - when the tree has no values, i.e. when the root is null.
	 * false - when the tree has values, i.e. when the root is different from null.
	 */
	public boolean isEmpty(){
		return this.root == null;
	}
	/**
	 * Returns a value in the Tree.
	 * @param key - The key associated to the value.
	 * @return The value associated to the input key.
	 */
	public V get(K key){
		TreeNode node = this.root;
		int result;
		while(node != null){
			result = key.compareTo(node.key);
			if(result == 0)
				return node.value;
			else if(result < 0)
				node = node.left;
			else if(result > 0)
				node = node.right;
		}
		return null;
	}
	/**
	 * Returns true if the given key exists in the Tree, false otherwise.
	 * @param key - The key that's going to be searched.
	 * @return true if the given key exists in the Tree, false otherwise.
	 */
	public boolean contains(K key){
		return (this.get(key) == null)?false:true;
	}
	/**
	 * Returns the number of nodes in the Tree.
	 * @return The number of nodes in the Tree, 0 if it is empty.
	 */
	public int size(){
		if(this.root == null){
			return 0;
		}
		return this.size(this.root);
	}
	private int size(TreeNode node){
		if(node == null)
			return 0;
		int output = this.size(node.left);
		output += this.size(node.right);
		output += 1;
		return output;
	}
	/**
	 * Puts a key,value pair in the Tree through iteration.
	 * @param key - The key that will position the pair.
	 * @param value - The value contained in the pair.
	 */
	public void put(K key, V value){
		TreeNode node = this.root;
		TreeNode temp = null;
		int result = 0;
		while(node != null){
			temp = node;
			result = key.compareTo(node.key);
			if(result == 0)
				break;
			else if(result < 0)	
				node = node.left;
			else if(result > 0) 
				node = node.right;
		}
		if(temp == null)
			this.root = new TreeNode(key,value);
		else if(result == 0)
			temp.value = value;
		else if(result > 0)
			temp.right = new TreeNode(key,value);
		else if(result < 0)
			temp.left = new TreeNode(key,value);
	}
	/**
	 * A key,value pair is added to the Tree through recursion.
	 * @param key - The key that will position the pair.
	 * @param value - The value contained in the pair.
	 */
	public void add(K key,V value){
		if(this.root == null){
			this.root = new TreeNode(key,value);
		}
		else{
			this.add(key, value,this.root);
		}
	}
	private void add(K key,V value,TreeNode node){
		int result = key.compareTo(node.key);
		if(result == 0)
			node.value = value;
		else if(result < 0){
			if(node.left == null){
				node.left = new TreeNode(key,value);
				return;
			}
			this.add(key, value,node.left);
		}
		else if(result > 0){
			if(node.right == null){
				node.right = new TreeNode(key,value);
				return;
			}
			this.add(key, value, node.right);
		}
	}
	/**
	 * Returns a String with the leaves of the Tree (the nodes that have no children)
	 * @return The String with each leaf in the Tree.
	 */
	public String leaves(){
		if(this.root == null){
			return "";
		}
		return this.leaves(this.root);
	}
	private String leaves(TreeNode node){
		if(node == null){
			return "";
		}
		String output = this.leaves(node.left);
		if(node.left == null && node.right == null){
			output += "[" + node.key.toString() +","+ node.value.toString()+"]";
			
		}
		output += this.leaves(node.right);
		return output;
	}
	/**
	 * Returns the number of leaves in the Tree (nodes that have no children).
	 * @return The number of leaves in the Tree.
	 */
	public int howManyLeaves(){
		if(this.root == null){
			return 0;
		}
		return this.howManyLeaves(this.root);
	}
	private int howManyLeaves(TreeNode node){
		if(node == null){
			return 0;
		}
		int output = this.howManyLeaves(node.left);
		if(node.left == null && node.right == null){
			output += 1;
		}
		output += this.howManyLeaves(node.right);
		return output;
	}
	/**
	 * Return a String containing the nodes that have greater keys than the given key using Comparable.
	 * @param key - They key whose bigger keys will be returned
	 * @return The String with the keys that are greater than the given key.
	 */
	public String biggerThan(K key){
		if(this.root == null){
			return "";
		}
		return this.biggerThan(key, this.root);
	}
	private String biggerThan(K key, TreeNode node){
		if(node == null)
			return "";
		String output = this.biggerThan(key,node.left);
		output += this.biggerThan(key,node.right);
		if(node.key.compareTo(key) > 0)
			output += "[" + node.key.toString() +","+ node.value.toString()+"]";
		return output;
	}
	/**
	 * Outputs the String representation of an In Order walk of the tree (Left, Do, Right).
	 * @return The String representation of this type of walk.
	 */
	public String inOrder(){
		if(root != null){
			return this.inOrder(root);
		}
		return "";
	}
	private String inOrder(TreeNode node){
		if(node == null)
			return "";
		String output = this.inOrder(node.left);
		output += "[" + node.key.toString() +","+ node.value.toString()+"]";
		output += this.inOrder(node.right);
		return output;
	}
	/**
	 * Outputs the String representation of a pre-order traversal of the tree (Do, Left, Right).
	 * @return The String representation of the pre-Order traversal.
	 */
	public String preOrder(){
		if(this.root != null){
			return this.preOrder(this.root);
		}
		return "";
	}
	private String preOrder(TreeNode node){
		if(node == null)
			return "";
		String output = "[" + node.key.toString() +","+ node.value.toString()+"]";
		output += this.preOrder(node.left);
		output += this.preOrder(node.right);
		return output;
	}
	/**
	 * Outputs the String representation of a Post order traversal of the tree (Left, Right, Do).
	 * @return The String representation of the Post Order traversal.
	 */
	public String postOrder(){
		if(this.root != null){
			return this.postOrder(this.root);
		}
		return "";
	}
	private String postOrder(TreeNode node){
		if(node == null)
			return "";
		String output = this.postOrder(node.left);
		output += this.postOrder(node.right);
		output += "[" + node.key.toString() +","+ node.value.toString()+"]";
		return output;
	}
	/**
	 * Returns the height of the tree (the further-most path from root to a leaf).
	 * @return The height of the tree.
	 */
	public int height(){
		if(this.root == null){
			return 0;
		}
		return height(this.root, 0);
	}
	/**
	 * An overloaded version of height() meant to return the height of a given node.
	 * @param node - The node whose height will be returned.
	 * @return The height of the given node.
	 */
	public int height(TreeNode node){
		if(node == null){
			return 0;
		}
		return height(node,0);
	}
	private int height(TreeNode node, int i){
		if(node != null){
			i++;
			int alturaL = height(node.left, i);
			int alturaR = height(node.right, i);
			return Math.max(alturaL, alturaR);
		}
		return i;
	}
	/**
	 * Returns a String with the nodes at the given level.
	 * @param i The level at which to search.
	 * @return The String with the nodes at the given level.
	 */
	public String inLevel(int i){
		if(this.root == null){
			return "";
		}
		return inLevel(i,this.root , 0);
	}
	private String inLevel(int theLevel, TreeNode node, int i){
		if(node == null){
			return "";
		}
		i++;
		String output = this.inLevel(theLevel,node.left,i);
		output += this.inLevel(theLevel,node.right,i);
		if(i == theLevel)
			output += "[" + node.key.toString() +","+ node.value.toString()+"]";
		return output;
	}
	/**
	 * Returns a String with the nodes in descending order based on the key.
	 * @return The String with the nodes in descending order based on the key.
	 */
	public String descending(){
		if(root != null){
			return this.descending(this.root);
		}
		return "";
	}
	private String descending(TreeNode node){
		if(node == null)
			return "";
		String output = this.descending(node.right);
		output += "[" + node.key.toString() +","+ node.value.toString()+"]";
		output += this.descending(node.left);
		return output;
	}
	/**
	 * Returns a String representing a Level Order traversal
	 * (nodes are numbered from top to bottom, from left to right).
	 * @return The String representing a Level Order traversal.
	 */
	public String levelOrder(){
		if(this.root == null){
			return "";
		}
		String output = "";
		int h = this.height(this.root,0);
		for(int i = 1; i < h+1; i++){
			output += this.inLevel(i);
		}
		return output;
	}
	/**
	 * Returns a String representing a Level Order traversal
	 * (nodes are numbered from top to bottom, from left to right) using a Queue (FIFO).
	 * @return The String representing a Level Order traversal.
	 */
	public String levelOrderQ(){
		Queue<String> q = new Queue<String>();
		if(this.root == null){
			return "";
		}
		String output = "";
		int h = this.height(this.root,0);
		for(int i = 1; i < h+1; i++){
			q.enqueue(this.inLevel(i));
		}
		while(!q.isEmpty()){
			output += q.dequeue();
		}
		return output;
	}
	/**
	 * Removes a key,value pair from the Tree and returns the value of the removed pair.
	 * @param key - The key associated to the key,value pair.
	 * @return The value from the key,value pair.
	 */
	public V remove(K key){
		TreeNode node = this.root;
		V temp;
		while(node != null){
			int cmp = key.compareTo(node.key);
			if(cmp == 0)
				break;
			else if(cmp > 0)
				node = node.right;
			else if(cmp < 0)
				node = node.left;
		}
		if(node == null)
			return null;
		else{
			temp = node.value;
			treeDelete(node);
		}
		return temp;
	}
	private void treeDelete(TreeNode node){
		if(node.left == null) transplant(node,node.right);
		else if(node.right == null) transplant(node,node.left);
		else{
			TreeNode max = maximum(node.left);
			if(!findParent(max).equals(node)){
				transplant(max,max.right);
				max.right = node.right;
			}
			transplant(node,max);
			TreeNode replace = null;
			if(max.left != null) replace = max.left;
			max.left = node.left;
			while(node.left != null){
				node = node.left;
			}
			node.right = replace;
		}
	}
	private void transplant(TreeNode u, TreeNode v){
		TreeNode uParent = findParent(u);
		
		if(uParent == null){
			this.root = v;
		}
		else if(u == uParent.left){
			uParent.left = v;
		}
		else{
			uParent.right = v;
		}
	}
	private TreeNode findParent(TreeNode node){
		if(node.equals(this.root)){
			return null;
		}
		TreeNode temp = this.root;
		TreeNode parent = temp;
		while(temp != null){
			int cmp = node.key.compareTo(temp.key);
			if(cmp == 0)
				break;
			else if(cmp > 0){
				parent = temp;
				temp = temp.right;
			}
			else if(cmp < 0){
				parent = temp;
				temp = temp.left;
			}
		}
		return parent;
	}
	private TreeNode maximum(TreeNode node){
		if(node == null)
			return null;
		else if(node.right == null)
			return node;
		while(node.right != null)
			node = node.right;
		return node;
	}
	/**
	 * The Node that represents the Key,Value pair that the tree consists of.
	 * @author fornesarturo
	 *
	 */
	private class TreeNode{
		protected K key;
		protected V value;
		
		TreeNode left, right;
		
		protected TreeNode(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
}
