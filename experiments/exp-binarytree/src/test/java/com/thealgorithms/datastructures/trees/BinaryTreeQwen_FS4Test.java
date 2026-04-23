package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public class BinaryTreeQwen_FS4Test {

    @Test
    void testPut_IntoEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(42));
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(42, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    void testPut_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        assertDoesNotThrow(() -> tree.put(30));
        Node root = tree.getRoot();
        assertNotNull(root.left);
        assertEquals(30, root.left.data);
        assertEquals(root, root.left.parent);
    }

    @Test
    void testPut_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        assertDoesNotThrow(() -> tree.put(70));
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(70, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(25);
        assertDoesNotThrow(() -> tree.put(25));
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(25, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_MultipleValues() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(100));
        assertDoesNotThrow(() -> tree.put(50));
        assertDoesNotThrow(() -> tree.put(150));
        assertDoesNotThrow(() -> tree.put(25));
        assertDoesNotThrow(() -> tree.put(75));
        
        Node root = tree.getRoot();
        assertEquals(100, root.data);
        assertEquals(50, root.left.data);
        assertEquals(150, root.right.data);
        assertEquals(25, root.left.left.data);
        assertEquals(75, root.left.right.data);
    }

    @Test
    void testPut_NegativeValue() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(-10));
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(-10, root.data);
    }

    @Test
    void testPut_ZeroValue() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(0));
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(0, root.data);
    }
}
// ```