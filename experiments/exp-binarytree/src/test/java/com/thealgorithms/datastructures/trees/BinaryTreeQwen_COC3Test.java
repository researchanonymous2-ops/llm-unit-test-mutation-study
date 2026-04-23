package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_COC3Test {

    private BinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
    }

    @Test
    void testPut_inEmptyTree() {
        tree.put(5);
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    void testPut_asLeftChild() {
        tree.put(5); 
        tree.put(3);

        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNotNull(root.left);
        assertEquals(3, root.left.data);
        assertNull(root.right);
        assertEquals(root, root.left.parent);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    void testPut_asRightChild() {
        tree.put(5); 
        tree.put(7);

        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNull(root.left);
        assertNotNull(root.right);
        assertEquals(7, root.right.data);
        assertEquals(root, root.right.parent);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }
}
// ```