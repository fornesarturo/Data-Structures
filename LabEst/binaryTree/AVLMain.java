package binaryTree;

public class AVLMain {
	public static void main(String[] args){
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(84);
		tree.insert(10);
		tree.insert(8);
		tree.insert(92);
		tree.insert(66);
		tree.insert(88);
		tree.insert(29);
		tree.insert(27);
		tree.insert(75);
		tree.insert(72);
		tree.insert(68);
		tree.insert(62);
		tree.insert(18);
		tree.insert(80);
		tree.insert(36);
		tree.insert(1);
		tree.insert(40);
		
		System.out.println();
		System.out.println("PreOrder: "+tree.preOrder());
		System.out.println("InOrder: "+tree.inOrder());
		
	}
}
