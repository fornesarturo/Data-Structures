package secondMidterm;


 
public class AVLTree {
 
    private static Node root;
    
    private int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }
    
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
    
    private int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }
 
    public Node insert(Node node, int key) {
         
        /* 1.  Perform the normal BST rotation */
        if (node == null) {
            return (new Node(key));
        }
 
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
 
        /* 2. Update height of this ancestor node */
        node.height = max(height(node.left), height(node.right)) + 1;
 
        /* 3. Get the balance factor of this ancestor node to check whether
         this node became unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
 
        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
 
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    class Node {
        int key, height;
        Node left, right;
        Node(int d) {
            key = d;
            height = 1;
        }
    }
 
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        
        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 25);
 
        tree.preOrder(root);
    }
}