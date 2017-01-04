package binaryTree;

public class BinarySearchTreeMain {
	public static void main(String[] args){
		BinarySearchTree<Integer,Integer> tree = new BinarySearchTree<Integer,Integer>();
		tree.put(1, 2);
		tree.add(2, 4);
		tree.add(3, 6);
		tree.add(-4, -8);
		tree.put(-2, -4);
		tree.put(-3, 0);
		
		System.out.println(tree.get(1));
		System.out.println(tree.get(2));
		System.out.println(tree.get(-2));
		
		System.out.println(tree.inOrder());
		
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		
		System.out.println(tree.contains(4));
		System.out.println(tree.contains(3));
		
		System.out.println(tree.size());
		System.out.println(tree.leaves());
		
		System.out.println(tree.howManyLeaves());
		
		System.out.println(tree.biggerThan(1));
		
		System.out.println(tree.inLevel(2));
		
		System.out.println(tree.descending());
		
		System.out.println(tree.levelOrderQ());
		
		System.out.println();
		System.out.println("-----------------Delete-----------------");
		System.out.println("InOrder: "+tree.inOrder());
		System.out.println("PreOrder: "+tree.preOrder());
		
		System.out.println();
		System.out.println("Removed:"+" "+tree.remove(-3));
		System.out.println();
		
		System.out.println("InOrder: "+tree.inOrder());
		System.out.println("PreOrder: "+tree.preOrder());
		System.out.println("-----------------Delete-----------------");
	}
}
