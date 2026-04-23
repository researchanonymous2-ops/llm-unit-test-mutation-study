package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeLlama_FS5Test {

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
    void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(10));
        assertNotNull(tree.getRoot().right);
        assertEquals(10, tree.getRoot().right.data);
    }

    @Test
    void testPut_MultipleInserts() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(10));
        assertDoesNotThrow(() -> tree.put(5));
        assertDoesNotThrow(() -> tree.put(20));
        assertDoesNotThrow(() -> tree.put(3));
        assertDoesNotThrow(() -> tree.put(7));
        assertDoesNotThrow(() -> tree.put(15));
        assertDoesNotThrow(() -> tree.put(25));

        assertEquals(10, tree.getRoot().data);
        assertEquals(5, tree.getRoot().left.data);
        assertEquals(20, tree.getRoot().right.data);
        assertEquals(3, tree.getRoot().left.left.data);
        assertEquals(7, tree.getRoot().left.right.data);
        assertEquals(15, tree.getRoot().right.left.data);
        assertEquals(25, tree.getRoot().right.right.data);
    }

    @Test
    void testPut_OnEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertNull(tree.getRoot());
        tree.put(10);
        assertNotNull(tree.getRoot());
    }
}
// ```