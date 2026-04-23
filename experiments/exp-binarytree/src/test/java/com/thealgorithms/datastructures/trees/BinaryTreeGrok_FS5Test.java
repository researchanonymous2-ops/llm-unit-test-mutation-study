package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_FS5Test {

    @Test
    void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(42));
    }

    @Test
    void testPut_InsertSmallerThanRoot() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        assertDoesNotThrow(() -> tree.put(25));
    }

    @Test
    void testPut_InsertLargerThanRoot() {
        BinaryTree tree = new BinaryTree();
        tree.put(30);
        assertDoesNotThrow(() -> tree.put(75));
    }

    @Test
    void testPut_InsertEqualToRoot() {
        BinaryTree tree = new BinaryTree();
        tree.put(60);
        assertDoesNotThrow(() -> tree.put(60));
    }

    @Test
    void testPut_MultipleInserts() {
        BinaryTree tree = new BinaryTree();
        tree.put(40);
        tree.put(20);
        tree.put(60);
        assertDoesNotThrow(() -> tree.put(10));
        assertDoesNotThrow(() -> tree.put(30));
        assertDoesNotThrow(() -> tree.put(50));
        assertDoesNotThrow(() -> tree.put(70));
    }

    @Test
    void testPut_NegativeValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(0);
        assertDoesNotThrow(() -> tree.put(-15));
    }

    @Test
    void testPut_LargeValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(100);
        assertDoesNotThrow(() -> tree.put(1000));
    }
}
// ```