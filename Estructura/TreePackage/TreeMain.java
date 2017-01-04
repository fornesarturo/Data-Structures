package TreePackage;

public class TreeMain {
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(0);
		root.sLeft(new BinaryNode(1));
		root.sRight(new BinaryNode(2));
		root.gLeft().sLeft(new BinaryNode(3));
		root.gRight().sLeft(new BinaryNode(3));
		BinaryTree tree = new BinaryTree(root);
		System.out.println("Is Empty: "+tree.isEmpty());
		System.out.println("Height: "+tree.Height(tree.gRoot()));
		System.out.println("Size: "+tree.Size());
		System.out.println("Count: "+tree.Count());
	}
}
