package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeGrok_COC3Test {

    private BinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
    }

    @Test
    void testPut_EmptyTree() {
        // Caminho P0: root == null
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertNull(tree.getRoot().right);
    }

    @Test
    void testPut_LeftChild() {
        // Caminho P1: root != null, value < parent.data
        tree.put(10);
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
        assertNull(tree.getRoot().right);
    }

    @Test
    void testPut_RightChild() {
        // Caminho P2: root != null, value >= parent.data
        tree.put(10);
        tree.put(15);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().right);
        assertEquals(15, tree.getRoot().right.data);
        assertNull(tree.getRoot().left);
    }
}
// ```