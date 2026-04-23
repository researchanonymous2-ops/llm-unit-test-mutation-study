package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_POT2Test {

    @Test
    public void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    public void testPut_ValueLessThanRoot() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // root
        tree.put(5);  // left child
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNull(root.right);
        assertEquals(root, root.left.parent);
    }

    @Test
    public void testPut_ValueGreaterOrEqualThanRoot() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // root
        tree.put(15); // right child
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertNull(root.left);
        assertEquals(root, root.right.parent);
    }
}
// ```