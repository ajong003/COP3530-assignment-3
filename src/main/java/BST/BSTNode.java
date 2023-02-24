package BST;

public class BSTNode

{
    String item;		// The data in the node
    BSTNode left; 	// Left child
    BSTNode right; 	// Right child

    BSTNode(String key) {
        this.item = key;
        this.left=null;
        this.right=null;
    }
}
