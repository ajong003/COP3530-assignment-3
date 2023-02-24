import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import BST.BinarySearchTree;
import Queue.MyQueue;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinarySearchTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    public BinarySearchTree testBST(){
        BinarySearchTree tree = new BinarySearchTree();

        // Testing for inserting words into the tree
        tree.put("dog");
        tree.put("cat");
        tree.put("alligator");
        tree.put("giraffe");
        tree.put("elephant");
        tree.put("hippo");
        tree.put("zebra");

        return tree;
    }

    @Test
    public void test_put() {
        BinarySearchTree tree = testBST();
        tree.printTreeStructure();
        Assertions.assertEquals(
                "\n" +
                "dog\n" +
                "  cat\n" +
                "    alligator\n" +
                "      null\n" +
                "      null\n" +
                "    null\n" +
                "  giraffe\n" +
                "    elephant\n" +
                "      null\n" +
                "      null\n" +
                "    hippo\n" +
                "      null\n" +
                "      zebra\n" +
                "        null\n" +
                "        null\n",
                outContent.toString());
    }

    @Test
    public void test_contains() {
        BinarySearchTree tree = testBST();
        Assertions.assertTrue(tree.contains("dog"));
        Assertions.assertTrue(tree.contains("alligator"));
        Assertions.assertFalse(tree.contains("horse"));
    }

    @Test
    public void test_delete() {
        BinarySearchTree tree = testBST();
        tree.delete("dog");
        tree.delete("elephant");
        tree.delete("cat");
        tree.printTreeStructure();
        Assertions.assertEquals(
                "\n" +
                "giraffe\n" +
                "  alligator\n" +
                "    null\n" +
                "    null\n" +
                "  hippo\n" +
                "    null\n" +
                "    zebra\n" +
                "      null\n" +
                "      null\n",
                outContent.toString());
    }

    @Test
    public void test_put_after_delete(){
        BinarySearchTree tree = testBST();
        tree.delete("dog");
        tree.delete("elephant");
        tree.delete("cat");
        tree.put("penguin");
        tree.put("aardvark");
        tree.put("bear");
        tree.printTreeStructure();
        Assertions.assertEquals(
        "\n" +
                "giraffe\n" +
                "  alligator\n" +
                "    aardvark\n" +
                "      null\n" +
                "      null\n" +
                "    bear\n" +
                "      null\n" +
                "      null\n" +
                "  hippo\n" +
                "    null\n" +
                "    zebra\n" +
                "      penguin\n" +
                "        null\n" +
                "        null\n" +
                "      null\n",
                outContent.toString());
    }

    @Test
    public void test_makeEmpty(){
        BinarySearchTree tree = testBST();
        tree.makeEmpty();
        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    public void test_OPTIONAL_inOrder(){
        BinarySearchTree tree = testBST();
        MyQueue inOrder = tree.inOrder();

        Assertions.assertEquals("(alligator, cat, dog, elephant, giraffe, hippo, zebra)", inOrder.toString());
    }

    @Test
    public void test_OPTIONAL_preOrder(){
        BinarySearchTree tree = testBST();
        MyQueue preOrder = tree.preOrder();

        Assertions.assertEquals("(dog, cat, alligator, giraffe, elephant, hippo, zebra)", preOrder.toString());
    }

    @Test
    public void test_OPTIONAL_postOrder(){
        BinarySearchTree tree = testBST();
        MyQueue postOrder = tree.postOrder();

        Assertions.assertEquals("(alligator, cat, elephant, zebra, hippo, giraffe, dog)", postOrder.toString());
    }

}