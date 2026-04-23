package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_POT3Test {

    @Test
    public void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertNull(tree.getRoot().right);
        assertNull(tree.getRoot().parent);
    }

    @Test
    public void testPut_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
        assertNull(tree.getRoot().left.left);
        assertNull(tree.getRoot().left.right);
        assertEquals(tree.getRoot(), tree.getRoot().left.parent);
    }

    @Test
    public void testPut_RightChildGreater() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(15);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().right);
        assertEquals(15, tree.getRoot().right.data);
        assertNull(tree.getRoot().right.left);
        assertNull(tree.getRoot().right.right);
        assertEquals(tree.getRoot(), tree.getRoot().right.parent);
    }

    @Test
    public void testPut_RightChildEqual() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNotNull(tree.getRoot().right);
        assertEquals(10, tree.getRoot().right.data);
        assertNull(tree.getRoot().right.left);
        assertNull(tree.getRoot().right.right);
        assertEquals(tree.getRoot(), tree.getRoot().right.parent);
    }
}
// ```