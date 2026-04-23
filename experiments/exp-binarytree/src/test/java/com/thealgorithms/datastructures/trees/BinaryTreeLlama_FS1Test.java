package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeLlama_FS1Test {

    @Test
    void testPut_SingleInsert() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(10));
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
    }

    @Test
    void testPut_InsertSmallerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(5));
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
    }

    @Test
    void testPut_InsertLargerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(20));
        assertNotNull(tree.getRoot().right);
        assertEquals(20, tree.getRoot().right.data);
    }

    @Test
    void testPut_MultipleInserts() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> {
            tree.put(10);
            tree.put(5);
            tree.put(20);
            tree.put(3);
            tree.put(7);
            tree.put(15);
            tree.put(25);
        });
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
        assertNotNull(tree.getRoot().right);
        assertEquals(20, tree.getRoot().right.data);
        assertNotNull(tree.getRoot().left.left);
        assertEquals(3, tree.getRoot().left.left.data);
        assertNotNull(tree.getRoot().left.right);
        assertEquals(7, tree.getRoot().left.right.data);
        assertNotNull(tree.getRoot().right.left);
        assertEquals(15, tree.getRoot().right.left.data);
        assertNotNull(tree.getRoot().right.right);
        assertEquals(25, tree.getRoot().right.right.data);
    }

    @Test
    void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(10));
        assertNotNull(tree.getRoot().right);
        assertEquals(10, tree.getRoot().right.data);
    }
}
// ```