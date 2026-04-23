package com.thealgorithms.datastructures.trees;

// ```java
import com.thealgorithms.datastructures.trees.BinaryTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeLlama_ZS4Test {

    @Test
    public void testPut_SingleElement() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        assertNotNull(tree.getRoot());
        assertEquals(5, tree.getRoot().data);
    }

    @Test
    public void testPut_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(3);
        assertNotNull(tree.getRoot().left);
        assertEquals(3, tree.getRoot().left.data);
    }

    @Test
    public void testPut_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(7);
        assertNotNull(tree.getRoot().right);
        assertEquals(7, tree.getRoot().right.data);
    }

    @Test
    public void testPut_MultipleElements() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(3);
        tree.put(7);
        tree.put(2);
        tree.put(4);
        tree.put(6);
        tree.put(8);
        assertEquals(5, tree.getRoot().data);
        assertEquals(3, tree.getRoot().left.data);
        assertEquals(7, tree.getRoot().right.data);
        assertEquals(2, tree.getRoot().left.left.data);
        assertEquals(4, tree.getRoot().left.right.data);
        assertEquals(6, tree.getRoot().right.left.data);
        assertEquals(8, tree.getRoot().right.right.data);
    }

    @Test
    public void testPut_DuplicateElement() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(5);
        assertNotNull(tree.getRoot().right);
        assertEquals(5, tree.getRoot().data);
        assertEquals(5, tree.getRoot().right.data);
    }
}
// ```