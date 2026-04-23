package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public class BinaryTreeQwen_OS3Test {

    @Test
    void testPut_rootInsert() {
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
    void testPut_leftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        Node root = tree.getRoot();
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertEquals(root, root.left.parent);
    }

    @Test
    void testPut_rightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(15);
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertNull(root.right.left);
        assertNull(root.right.right);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_multipleValues() {
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
        assertEquals(5, root.left.data);
        assertEquals(15, root.right.data);
        assertEquals(3, root.left.left.data);
        assertEquals(7, root.left.right.data);
        assertEquals(12, root.right.left.data);
        assertEquals(18, root.right.right.data);
    }

    @Test
    void testPut_duplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(10); // Duplicate value
        Node root = tree.getRoot();
        assertEquals(10, root.data);
        // As per implementation, duplicates go to the right
        assertNotNull(root.right);
        assertEquals(10, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    void testPut_negativeValues() {
        BinaryTree tree = new BinaryTree();
        tree.put(-10);
        tree.put(-20);
        tree.put(-5);
        Node root = tree.getRoot();
        assertEquals(-10, root.data);
        assertEquals(-20, root.left.data);
        assertEquals(-5, root.right.data);
    }

    @Test
    void testPut_zeroValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(0);
        Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(0, root.data);
    }

    @Test
    void testPut_largeValues() {
        BinaryTree tree = new BinaryTree();
        tree.put(Integer.MAX_VALUE);
        tree.put(Integer.MIN_VALUE);
        Node root = tree.getRoot();
        assertEquals(Integer.MAX_VALUE, root.data);
        assertNotNull(root.left);
        assertEquals(Integer.MIN_VALUE, root.left.data);
        assertEquals(root, root.left.parent);
    }

    @Test
    void testPut_doesNotThrow() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(42));
    }
}
// ```