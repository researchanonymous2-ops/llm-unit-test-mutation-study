package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BinaryTreeGrok_COC4Test {

    @Test
    void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertNull(tree.getRoot().right);
    }

    @Test
    void testPut_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
        assertNull(tree.getRoot().right);
    }

    @Test
    void testPut_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(15);
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().right);
        assertEquals(15, tree.getRoot().right.data);
        assertNull(tree.getRoot().left);
    }

    @Test
    void testPut_Duplicate() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10);
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().right);
        assertEquals(10, tree.getRoot().right.data);
        assertNull(tree.getRoot().left);
    }
}
// ```