package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeGrok_ZS1Test {

    @Test
    public void testPut_InsertIntoEmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertNull(tree.getRoot().right);
    }

    @Test
    public void testPut_InsertSmallerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
        assertNull(tree.getRoot().right);
    }

    @Test
    public void testPut_InsertLargerValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(15);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().right);
        assertEquals(15, tree.getRoot().right.data);
        assertNull(tree.getRoot().left);
    }

    @Test
    public void testPut_InsertEqualValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().right);
        assertEquals(10, tree.getRoot().right.data);
        assertNull(tree.getRoot().left);
    }

    @Test
    public void testPut_MultipleInserts() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3);
        tree.put(7);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
        assertNotNull(tree.getRoot().right);
        assertEquals(15, tree.getRoot().right.data);
        assertNotNull(tree.getRoot().left.left);
        assertEquals(3, tree.getRoot().left.left.data);
        assertNotNull(tree.getRoot().left.right);
        assertEquals(7, tree.getRoot().left.right.data);
    }
}
// ```