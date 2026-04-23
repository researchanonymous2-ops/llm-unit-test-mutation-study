package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public class BinaryTreeGrok_ZS3Test {

    @Test
    public void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    public void testPut_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        Node root = tree.getRoot();
        assertEquals(10, root.data);
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertEquals(root, root.left.parent);
        assertNull(root.right);
    }

    @Test
    public void testPut_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(15);
        Node root = tree.getRoot();
        assertEquals(10, root.data);
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertNull(root.right.left);
        assertNull(root.right.right);
        assertEquals(root, root.right.parent);
        assertNull(root.left);
    }

    @Test
    public void testPut_EqualValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10);
        Node root = tree.getRoot();
        assertEquals(10, root.data);
        assertNotNull(root.right);
        assertEquals(10, root.right.data);
        assertNull(root.right.left);
        assertNull(root.right.right);
        assertEquals(root, root.right.parent);
        assertNull(root.left);
    }

    @Test
    public void testPut_DeepLeft() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        tree.put(3);
        Node root = tree.getRoot();
        assertEquals(10, root.data);
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNotNull(root.left.left);
        assertEquals(3, root.left.left.data);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        assertEquals(root.left, root.left.left.parent);
        assertNull(root.left.right);
        assertNull(root.right);
    }

    @Test
    public void testPut_DeepRight() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(15);
        tree.put(20);
        Node root = tree.getRoot();
        assertEquals(10, root.data);
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertNotNull(root.right.right);
        assertEquals(20, root.right.right.data);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
        assertEquals(root.right, root.right.right.parent);
        assertNull(root.right.left);
        assertNull(root.left);
    }

    @Test
    public void testPut_MultipleInserts() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3);
        tree.put(7);
        tree.put(12);
        tree.put(18);
        Node root = tree.getRoot();
        assertEquals(10, root.data);
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNotNull(root.left.left);
        assertEquals(3, root.left.left.data);
        assertNotNull(root.left.right);
        assertEquals(7, root.left.right.data);
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertNotNull(root.right.left);
        assertEquals(12, root.right.left.data);
        assertNotNull(root.right.right);
        assertEquals(18, root.right.right.data);
    }
}
// ```