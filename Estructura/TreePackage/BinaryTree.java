package TreePackage;

public class BinaryTree implements BTree{

	private BinaryNode root;
	
	public BinaryTree(){
		this.root = null;
	}
	
	public BinaryTree(int i){
		this.root = new BinaryNode(i);
	}
	
	public BinaryTree(BinaryNode node){
		this.root = node;
	}
	
	public boolean isEmpty() {
		return (this.root == null);
	}

	public BinaryNode gRoot() {
		return this.root;
	}

	
	public int Count() {
		return this.Count(this.root);
	}
	
	private int Count(BinaryNode ATree){
		if(ATree == null)
			return 0;
		if(ATree.gLeft() == null && ATree.gRight() == null)
			return 1;
		int count = Count((BinaryNode) ATree.gLeft());
		count += Count((BinaryNode) ATree.gRight());
		
		return count;
	}

	public int Size(BinaryNode ATree) {
		if(ATree == null)
			return 0;
		int left = Size((BinaryNode) ATree.gLeft());
		int right = Size((BinaryNode) ATree.gRight());
		
		int size = left+right+1;
		return size;
	}

	public int Height(BinaryNode ATree) {
		if(ATree == null)
			return 0;
		int hLeft = Height((BinaryNode) ATree.gLeft());
		int hRight = Height((BinaryNode) ATree.gRight());
		
		int height = Math.max(hLeft, hRight)+1;
		return height;
	}

	public int Size() {
		return this.Size(this.root);
	}
}
