package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public class BinaryTreeQwen_FS2Test {

    @Test
    void testPut_rootIsNull_shouldSetRoot() {
        BinaryTree tree = new BinaryTree();
        tree.put(42);
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(42, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    void testPut_valueLessThanRoot_shouldInsertLeft() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(30);
        Node root = tree.getRoot();
        assertNotNull(root.left);
        assertEquals(30, root.left.data);
        assertEquals(root, root.left.parent);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    void testPut_valueGreaterThanRoot_shouldInsertRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(70);
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(70, root.right.data);
        assertEquals(root, root.right.parent);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void testPut_duplicateValue_shouldInsertToRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(50);
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(50, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_multipleValues_shouldMaintainBSTProperty() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(30);
        tree.put(70);
        tree.put(20);
        tree.put(40);
        tree.put(60);
        tree.put(80);

        Node root = tree.getRoot();
        assertEquals(50, root.data);

        assertNotNull(root.left);
        assertEquals(30, root.left.data);
        assertEquals(root, root.left.parent);

        assertNotNull(root.right);
        assertEquals(70, root.right.data);
        assertEquals(root, root.right.parent);

        assertEquals(20, root.left.left.data);
        assertEquals(40, root.left.right.data);
        assertEquals(60, root.right.left.data);
        assertEquals(80, root.right.right.data);
    }

    @Test
    void testPut_negativeValue_shouldInsertCorrectly() {
        BinaryTree tree = new BinaryTree();
        tree.put(-10);
        tree.put(-20);
        tree.put(-5);

        Node root = tree.getRoot();
        assertEquals(-10, root.data);
        assertNotNull(root.left);
        assertEquals(-20, root.left.data);
        assertNotNull(root.right);
        assertEquals(-5, root.right.data);
    }

    @Test
    void testPut_zeroValue_shouldInsertCorrectly() {
        BinaryTree tree = new BinaryTree();
        tree.put(0);
        tree.put(-1);
        tree.put(1);

        Node root = tree.getRoot();
        assertEquals(0, root.data);
        assertNotNull(root.left);
        assertEquals(-1, root.left.data);
        assertNotNull(root.right);
        assertEquals(1, root.right.data);
    }

    @Test
    void testPut_largeValue_shouldInsertCorrectly() {
        BinaryTree tree = new BinaryTree();
        tree.put(1000000);
        tree.put(2000000);
        tree.put(500000);

        Node root = tree.getRoot();
        assertEquals(1000000, root.data);
        assertNotNull(root.left);
        assertEquals(500000, root.left.data);
        assertNotNull(root.right);
        assertEquals(2000000, root.right.data);
    }

    @Test
    void testPut_sameValueMultipleTimes_shouldInsertAllToRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10);
        tree.put(10);

        Node root = tree.getRoot();
        assertEquals(10, root.data);
        assertNotNull(root.right);
        assertEquals(10, root.right.data);
        assertNotNull(root.right.right);
        assertEquals(10, root.right.right.data);
    }

    @Test
    void testPut_decreasingOrder_shouldFormLeftSkewedTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(100);
        tree.put(80);
        tree.put(60);
        tree.put(40);
        tree.put(20);

        Node current = tree.getRoot();
        assertEquals(100, current.data);
        current = current.left;
        assertEquals(80, current.data);
        current = current.left;
        assertEquals(60, current.data);
        current = current.left;
        assertEquals(40, current.data);
        current = current.left;
        assertEquals(20, current.data);
    }

    @Test
    void testPut_increasingOrder_shouldFormRightSkewedTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(20);
        tree.put(40);
        tree.put(60);
        tree.put(80);
        tree.put(100);

        Node current = tree.getRoot();
        assertEquals(20, current.data);
        current = current.right;
        assertEquals(40, current.data);
        current = current.right;
        assertEquals(60, current.data);
        current = current.right;
        assertEquals(80, current.data);
        current = current.right;
        assertEquals(100, current.data);
    }

    @Test
    void testPut_noExceptionOnEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(123));
    }

    @Test
    void testPut_noExceptionOnNonEmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(100);
        assertDoesNotThrow(() -> tree.put(200));
    }
}
// ```