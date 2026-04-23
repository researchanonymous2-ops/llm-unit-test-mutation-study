package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_ZS2Test {

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
        
        assertNotNull(root.left);
        assertEquals(3, root.left.data);
        assertEquals(root, root.left.parent);
        
        assertNotNull(root.right);
        assertEquals(7, root.right.data);
        assertEquals(root, root.right.parent);
        
        assertNotNull(root.left.left);
        assertEquals(1, root.left.left.data);
        assertEquals(root.left, root.left.left.parent);
        
        assertNotNull(root.left.right);
        assertEquals(4, root.left.right.data);
        assertEquals(root.left, root.left.right.parent);
        
        assertNotNull(root.right.left);
        assertEquals(6, root.right.left.data);
        assertEquals(root.right, root.right.left.parent);
        
        assertNotNull(root.right.right);
        assertEquals(8, root.right.right.data);
        assertEquals(root.right, root.right.right.parent);
    }

    @Test
    void testPut_InsertValuesInAscendingOrder() {
        binaryTree.put(1);
        binaryTree.put(2);
        binaryTree.put(3);
        binaryTree.put(4);
        binaryTree.put(5);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(1, root.data);
        assertNull(root.left);
        assertNotNull(root.right);
        assertEquals(2, root.right.data);
        assertEquals(root, root.right.parent);
        assertNull(root.right.left);
        assertNotNull(root.right.right);
        assertEquals(3, root.right.right.data);
        assertEquals(root.right, root.right.right.parent);
    }

    @Test
    void testPut_InsertValuesInDescendingOrder() {
        binaryTree.put(5);
        binaryTree.put(4);
        binaryTree.put(3);
        binaryTree.put(2);
        binaryTree.put(1);
        
        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(5, root.data);
        assertNotNull(root.left);
        assertEquals(4, root.left.data);
        assertEquals(root, root.left.parent);
        assertNull(root.right);
        assertNotNull(root.left.left);
        assertEquals(3, root.left.left.data);
        assertEquals(root.left, root.left.left.parent);
        assertNotNull(root.left.left.left);
        assertEquals(2, root.left.left.left.data);
        assertEquals(root.left.left, root.left.left.left.parent);
    }
}
// ```