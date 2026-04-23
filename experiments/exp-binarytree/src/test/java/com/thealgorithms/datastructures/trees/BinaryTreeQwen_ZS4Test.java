package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_ZS4Test {

    private BinaryTree binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testPut_IntoEmptyTree() {
        binaryTree.put(5);
        BinaryTree.Node root = binaryTree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    public void testPut_LessThanRoot() {
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
    public void testPut_GreaterThanRoot() {
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
    public void testPut_EqualToRoot() {
        binaryTree.put(5);
        binaryTree.put(5);
        BinaryTree.Node root = binaryTree.getRoot();
        assertNotNull(root.right);
        assertEquals(5, root.right.data);
        assertEquals(root, root.right.parent);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    public void testPut_MultipleValues() {
        binaryTree.put(5);
        binaryTree.put(3);
        binaryTree.put(7);
        binaryTree.put(2);
        binaryTree.put(4);
        binaryTree.put(6);
        binaryTree.put(8);

        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(5, root.data);

        assertEquals(3, root.left.data);
        assertEquals(root, root.left.parent);
        assertEquals(2, root.left.left.data);
        assertEquals(root.left, root.left.left.parent);
        assertEquals(4, root.left.right.data);
        assertEquals(root.left, root.left.right.parent);

        assertEquals(7, root.right.data);
        assertEquals(root, root.right.parent);
        assertEquals(6, root.right.left.data);
        assertEquals(root.right, root.right.left.parent);
        assertEquals(8, root.right.right.data);
        assertEquals(root.right, root.right.right.parent);
    }

    @Test
    public void testPut_NegativeValues() {
        binaryTree.put(-5);
        binaryTree.put(-10);
        binaryTree.put(-3);

        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(-5, root.data);
        assertEquals(-10, root.left.data);
        assertEquals(root, root.left.parent);
        assertEquals(-3, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    public void testPut_ZeroValue() {
        binaryTree.put(0);
        binaryTree.put(-1);
        binaryTree.put(1);

        BinaryTree.Node root = binaryTree.getRoot();
        assertEquals(0, root.data);
        assertEquals(-1, root.left.data);
        assertEquals(root, root.left.parent);
        assertEquals(1, root.right.data);
        assertEquals(root, root.right.parent);
    }
}
// ```