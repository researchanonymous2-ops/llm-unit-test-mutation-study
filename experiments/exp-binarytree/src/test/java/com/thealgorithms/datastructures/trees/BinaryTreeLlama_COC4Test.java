package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public class BinaryTreeLlama_COC4Test {

    @Test
    public void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().data);
    }

    @Test
    public void testPut_LeftChild() {
        BinaryTree tree = new BinaryTree(new Node(5));
        tree.put(3);
        Node root = tree.getRoot();
        assertNotNull(root.left);
        assertEquals(3, root.left.data);
        assertEquals(root, root.left.parent);
    }

    @Test
    public void testPut_RightChild() {
        BinaryTree tree = new BinaryTree(new Node(5));
        tree.put(7);
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(7, root.right.data);
        assertEquals(root, root.right.parent);
    }

    @Test
    public void testPut_MultipleValues() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(3);
        tree.put(7);
        tree.put(2);
        tree.put(4);
        tree.put(6);
        tree.put(8);

        Node root = tree.getRoot();
        assertEquals(5, root.data);
        assertEquals(3, root.left.data);
        assertEquals(7, root.right.data);
        assertEquals(2, root.left.left.data);
        assertEquals(4, root.left.right.data);
        assertEquals(6, root.right.left.data);
        assertEquals(8, root.right.right.data);
    }

    @Test
    public void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree(new Node(5));
        tree.put(5);
        Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(5, root.right.data);
        assertEquals(root, root.right.parent);
    }
}
// ```