package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_POT1Test {

    @Test
    public void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertNull(tree.getRoot().right);
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
        assertNull(tree.getRoot().right);
    }

    @Test
    public void testPut_RightChild() {
        BinaryTree tree = new BinaryTree();
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