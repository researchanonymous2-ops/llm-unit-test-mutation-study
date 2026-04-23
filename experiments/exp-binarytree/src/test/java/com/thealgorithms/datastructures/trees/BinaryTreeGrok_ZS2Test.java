package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryTreeGrok_ZS2Test {

    @Test
    public void testPut_EmptyTree() {
        BinaryTree bt = new BinaryTree();
        bt.put(5);
        assertNotNull(bt.getRoot());
        assertEquals(5, bt.getRoot().data);
        assertNull(bt.getRoot().left);
        assertNull(bt.getRoot().right);
    }

    @Test
    public void testPut_LeftChild() {
        BinaryTree bt = new BinaryTree();
        bt.put(5);
        bt.put(3);
        assertEquals(5, bt.getRoot().data);
        assertNotNull(bt.getRoot().left);
        assertEquals(3, bt.getRoot().left.data);
        assertNull(bt.getRoot().left.left);
        assertNull(bt.getRoot().left.right);
        assertNull(bt.getRoot().right);
    }

    @Test
    public void testPut_RightChild() {
        BinaryTree bt = new BinaryTree();
        bt.put(5);
        bt.put(7);
        assertEquals(5, bt.getRoot().data);
        assertNotNull(bt.getRoot().right);
        assertEquals(7, bt.getRoot().right.data);
        assertNull(bt.getRoot().right.left);
        assertNull(bt.getRoot().right.right);
        assertNull(bt.getRoot().left);
    }

    @Test
    public void testPut_DuplicateValue() {
        BinaryTree bt = new BinaryTree();
        bt.put(5);
        bt.put(5);
        assertEquals(5, bt.getRoot().data);
        assertNotNull(bt.getRoot().right);
        assertEquals(5, bt.getRoot().right.data);
        assertNull(bt.getRoot().left);
    }

    @Test
    public void testPut_MultipleInserts() {
        BinaryTree bt = new BinaryTree();
        bt.put(10);
        bt.put(5);
        bt.put(15);
        bt.put(3);
        bt.put(7);
        assertEquals(10, bt.getRoot().data);
        assertEquals(5, bt.getRoot().left.data);
        assertEquals(15, bt.getRoot().right.data);
        assertEquals(3, bt.getRoot().left.left.data);
        assertEquals(7, bt.getRoot().left.right.data);
    }
}
// ```