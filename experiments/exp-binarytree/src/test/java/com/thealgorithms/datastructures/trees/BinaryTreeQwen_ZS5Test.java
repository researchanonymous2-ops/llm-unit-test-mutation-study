package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_ZS5Test {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    void testPut_InsertIntoEmptyTree() {
        binaryTree.put(5);
        BinaryTree.Node root = binaryTree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    void testPut_InsertSmallerValue() {
        binaryTree.put(5);
        binaryTree.put(3);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertNotNull(root.left);
        assertEquals(3, root.left.data);
        assertEquals(root, root.left.parent);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    void testPut_InsertLargerValue() {
        binaryTree.put(5);
        binaryTree.put(7);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertNotNull(root.right);
        assertEquals(7, root.right.data);
        assertEquals(root, root.right.parent);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void testPut_InsertDuplicateValue() {
        binaryTree.put(5);
        binaryTree.put(5);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertNotNull(root.right);
        assertEquals(5, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_InsertMultipleValues() {
        binaryTree.put(5);
        binaryTree.put(3);
        binaryTree.put(7);
        binaryTree.put(1);
        binaryTree.put(4);
        binaryTree.put(6);
        binaryTree.put(8);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(5, root.data);
        assertEquals(3, root.left.data);
        assertEquals(7, root.right.data);
        assertEquals(1, root.left.left.data);
        assertEquals(4, root.left.right.data);
        assertEquals(6, root.right.left.data);
        assertEquals(8, root.right.right.data);
    }

    @Test
    void testPut_InsertValuesInAscendingOrder() {
        binaryTree.put(1);
        binaryTree.put(2);
        binaryTree.put(3);
        binaryTree.put(4);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(1, root.data);
        assertEquals(2, root.right.data);
        assertEquals(3, root.right.right.data);
        assertEquals(4, root.right.right.right.data);
    }

    @Test
    void testPut_InsertValuesInDescendingOrder() {
        binaryTree.put(4);
        binaryTree.put(3);
        binaryTree.put(2);
        binaryTree.put(1);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(4, root.data);
        assertEquals(3, root.left.data);
        assertEquals(2, root.left.left.data);
        assertEquals(1, root.left.left.left.data);
    }
}
// ```