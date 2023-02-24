package BST;
import Queue.MyQueue;

interface BSTInterface {

    public boolean isEmpty(); // returns true if the BST is empty, false otherwise

    public void makeEmpty(); // Empties the BST

    public MyQueue inOrder(); // Returns a queue with the elements in order

    public MyQueue preOrder(); // Returns a queue with the elements pre order

    public MyQueue postOrder(); // Returns a queue with the elements post order

    public boolean contains(String s); // Returns true if the BST contains the String, false otherwise

    public void put(String s); // Adds a String to the BST. If the String is already in the BST, does nothing.

    public void delete(String s); // Removes a String from the BST. If the String isn't in the BST, does nothing.

}
