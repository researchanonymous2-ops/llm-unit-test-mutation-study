package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_COC2Test {

    @Test
    void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
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
        assertEquals(5, tree.getRoot().left.data);
        assertNull(tree.getRoot().right);
    }

    @Test
    void testPut_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(15);
        assertEquals(10, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertEquals(15, tree.getRoot().right.data);
    }

    @Test
    void testPut_RightChildEqual() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10);
        assertEquals(10, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertEquals(10, tree.getRoot().right.data);
    }
}
// ```