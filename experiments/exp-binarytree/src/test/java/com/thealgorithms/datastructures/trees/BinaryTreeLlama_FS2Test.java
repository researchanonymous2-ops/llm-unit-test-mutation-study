package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeLlama_FS2Test {

    @Test
    void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(10));
        assertEquals(10, tree.getRoot().data);
    }

    @Test
    void testPut_SingleInsertSmallerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(5));
        assertEquals(10, tree.getRoot().data);
        assertEquals(5, tree.getRoot().left.data);
    }

    @Test
    void testPut_SingleInsertLargerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(20));
        assertEquals(10, tree.getRoot().data);
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
        tree.put(15);
        tree.put(25);
        assertEquals(10, tree.getRoot().data);
        assertEquals(5, tree.getRoot().left.data);
        assertEquals(20, tree.getRoot().right.data);
        assertEquals(3, tree.getRoot().left.left.data);
        assertEquals(7, tree.getRoot().left.right.data);
        assertEquals(15, tree.getRoot().right.left.data);
        assertEquals(25, tree.getRoot().right.right.data);
    }

    @Test
    void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(10));
        assertEquals(10, tree.getRoot().data);
        assertEquals(10, tree.getRoot().right.data);
    }
}
// ```