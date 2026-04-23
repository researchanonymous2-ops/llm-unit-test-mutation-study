package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeQwen_FS3Test {

    @Test
    void testPut_rootIsNull_shouldSetRoot() {
        BinaryTree tree = new BinaryTree();
        tree.put(42);
        assertNotNull(tree.getRoot());
        assertEquals(42, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertNull(tree.getRoot().right);
        assertNull(tree.getRoot().parent);
    }

    @Test
    void testPut_valueLessThanRoot_shouldInsertLeft() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(30);
        assertNotNull(tree.getRoot().left);
        assertEquals(30, tree.getRoot().left.data);
        assertEquals(tree.getRoot(), tree.getRoot().left.parent);
    }

    @Test
    void testPut_valueGreaterThanRoot_shouldInsertRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(70);
        assertNotNull(tree.getRoot().right);
        assertEquals(70, tree.getRoot().right.data);
        assertEquals(tree.getRoot(), tree.getRoot().right.parent);
    }

    @Test
    void testPut_duplicateValue_shouldInsertToRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(50);
        tree.put(50);
        assertNotNull(tree.getRoot().right);
        assertEquals(50, tree.getRoot().right.data);
        assertEquals(tree.getRoot(), tree.getRoot().right.parent);
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

        assertEquals(50, tree.getRoot().data);
        assertEquals(30, tree.getRoot().left.data);
        assertEquals(70, tree.getRoot().right.data);
        assertEquals(20, tree.getRoot().left.left.data);
        assertEquals(40, tree.getRoot().left.right.data);
        assertEquals(60, tree.getRoot().right.left.data);
        assertEquals(80, tree.getRoot().right.right.data);
    }

    @Test
    void testPut_negativeValue_shouldInsertCorrectly() {
        BinaryTree tree = new BinaryTree();
        tree.put(-10);
        tree.put(-20);
        tree.put(-5);
        assertEquals(-10, tree.getRoot().data);
        assertEquals(-20, tree.getRoot().left.data);
        assertEquals(-5, tree.getRoot().right.data);
    }

    @Test
    void testPut_zeroValue_shouldInsertCorrectly() {
        BinaryTree tree = new BinaryTree();
        tree.put(0);
        assertEquals(0, tree.getRoot().data);
    }

    @Test
    void testPut_largeValue_shouldInsertCorrectly() {
        BinaryTree tree = new BinaryTree();
        tree.put(Integer.MAX_VALUE);
        tree.put(Integer.MIN_VALUE);
        assertEquals(Integer.MAX_VALUE, tree.getRoot().data);
        assertEquals(Integer.MIN_VALUE, tree.getRoot().left.data);
    }

    @Test
    void testPut_multipleSameValues_shouldCreateChainToRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10);
        tree.put(10);
        assertNotNull(tree.getRoot().right);
        assertNotNull(tree.getRoot().right.right);
    }

    @Test
    void testPut_valuesInDescendingOrder_shouldCreateLeftChain() {
        BinaryTree tree = new BinaryTree();
        tree.put(100);
        tree.put(80);
        tree.put(60);
        tree.put(40);
        tree.put(20);
        assertEquals(100, tree.getRoot().data);
        assertEquals(80, tree.getRoot().left.data);
        assertEquals(60, tree.getRoot().left.left.data);
        assertEquals(40, tree.getRoot().left.left.left.data);
        assertEquals(20, tree.getRoot().left.left.left.left.data);
    }

    @Test
    void testPut_valuesInAscendingOrder_shouldCreateRightChain() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(20);
        tree.put(30);
        tree.put(40);
        tree.put(50);
        assertEquals(10, tree.getRoot().data);
        assertEquals(20, tree.getRoot().right.data);
        assertEquals(30, tree.getRoot().right.right.data);
        assertEquals(40, tree.getRoot().right.right.right.data);
        assertEquals(50, tree.getRoot().right.right.right.right.data);
    }
}
// ```