package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeLlama_FS4Test {

    @Test
    void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(10));
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
    }

    @Test
    void testPut_SingleInsertSmallerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(5));
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
    }

    @Test
    void testPut_SingleInsertLargerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(20));
        assertNotNull(tree.getRoot().right);
        assertEquals(20, tree.getRoot().right.data);
    }

    @Test
    void testPut_MultipleInserts() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        tree.put(20);
        tree.put(3);
        tree.put(7);
        assertNotNull(tree.getRoot().left.left);
        assertEquals(3, tree.getRoot().left.left.data);
        assertNotNull(tree.getRoot().left.right);
        assertEquals(7, tree.getRoot().left.right.data);
        assertNotNull(tree.getRoot().right);
        assertEquals(20, tree.getRoot().right.data);
    }

    @Test
    void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(10));
        assertNotNull(tree.getRoot().right);
        assertEquals(10, tree.getRoot().right.data);
    }

    @Test
    void testPut_NegativeValue() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(-10));
        assertNotNull(tree.getRoot());
        assertEquals(-10, tree.getRoot().data);
    }
}
// ```