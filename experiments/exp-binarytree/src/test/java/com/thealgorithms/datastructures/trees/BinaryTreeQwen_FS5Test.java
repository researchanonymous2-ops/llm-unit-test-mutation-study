package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public class BinaryTreeQwen_FS5Test {

    @Test
    void testPut_rootIsNull_shouldSetRootWithGivenValue() {
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
    void testPut_valueLessThanRoot_shouldInsertAsLeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(30);
        Node root = tree.getRoot();
        assertNotNull(root.left);
        assertEquals(30, root.left.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertEquals(root, root.left.parent);
    }

    @Test
    void testPut_valueGreaterThanRoot_shouldInsertAsRightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(70);
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(70, root.right.data);
        assertNull(root.right.left);
        assertNull(root.right.right);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_duplicateValue_shouldInsertToTheRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(100);
        tree.put(100);
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(100, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_multipleValues_shouldMaintainBinarySearchTreeProperty() {
        BinaryTree tree = new BinaryTree();
        tree.put(50); // root
        tree.put(30); // left
        tree.put(70); // right
        tree.put(20); // left of 30
        tree.put(40); // right of 30
        tree.put(60); // left of 70
        tree.put(80); // right of 70

        Node root = tree.getRoot();
        assertEquals(50, root.data);

        assertNotNull(root.left);
        assertEquals(30, root.left.data);
        assertEquals(root, root.left.parent);

        assertNotNull(root.right);
        assertEquals(70, root.right.data);
        assertEquals(root, root.right.parent);

        assertNotNull(root.left.left);
        assertEquals(20, root.left.left.data);
        assertEquals(root.left, root.left.left.parent);

        assertNotNull(root.left.right);
        assertEquals(40, root.left.right.data);
        assertEquals(root.left, root.left.right.parent);

        assertNotNull(root.right.left);
        assertEquals(60, root.right.left.data);
        assertEquals(root.right, root.right.left.parent);

        assertNotNull(root.right.right);
        assertEquals(80, root.right.right.data);
        assertEquals(root.right, root.right.right.parent);
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
        assertEquals(root, root.left.parent);

        assertNotNull(root.right);
        assertEquals(-5, root.right.data);
        assertEquals(root, root.right.parent);
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
        assertEquals(root, root.left.parent);

        assertNotNull(root.right);
        assertEquals(1, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_largeValue_shouldInsertWithoutException() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(Integer.MAX_VALUE));
        assertDoesNotThrow(() -> tree.put(Integer.MIN_VALUE));
        
        Node root = tree.getRoot();
        assertEquals(Integer.MAX_VALUE, root.data);

        assertNotNull(root.left);
        assertEquals(Integer.MIN_VALUE, root.left.data);
        assertEquals(root, root.left.parent);
    }
}
// ```