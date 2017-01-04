package TreePackage;

public class BinaryNode implements BTNode{

	private int key;
	private BinaryNode left,right;
	
	public BinaryNode(int k){
		this.key = k;
	}
	
	public int gKey() {
		return this.key;
	}

	public BTNode gLeft() {
		return (BinaryNode) this.left;
	}

	public BTNode gRight() {
		return (BinaryNode) this.right;
	}

	public void sKey(int AValue) {
		this.key = AValue;
	}

	public void sLeft(BTNode AValue) {
		this.left = (BinaryNode) AValue;
		
	}

	public void sRight(BTNode AValue) {
		this.right = (BinaryNode) AValue;
		
	}
	
}
