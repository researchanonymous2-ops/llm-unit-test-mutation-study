package com.thealgorithms.datastructures.trees;

// ```java
import com.thealgorithms.datastructures.trees.BinaryTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeLlama_ZS2Test {

    @Test
    public void testPut_RootNode() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(5);
        assertNotNull(binaryTree.getRoot());
        assertEquals(5, binaryTree.getRoot().data);
    }

    @Test
    public void testPut_LeftChild() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(5);
        binaryTree.put(3);
        assertNotNull(binaryTree.getRoot().left);
        assertEquals(3, binaryTree.getRoot().left.data);
    }

    @Test
    public void testPut_RightChild() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(5);
        binaryTree.put(7);
        assertNotNull(binaryTree.getRoot().right);
        assertEquals(7, binaryTree.getRoot().right.data);
    }

    @Test
    public void testPut_DuplicateValue() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(5);
        binaryTree.put(5);
        assertNotNull(binaryTree.getRoot().right);
        assertEquals(5, binaryTree.getRoot().right.data);
    }

    @Test
    public void testPut_MultipleValues() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(5);
        binaryTree.put(3);
        binaryTree.put(7);
        binaryTree.put(2);
        binaryTree.put(4);
        binaryTree.put(6);
        binaryTree.put(8);
        assertEquals(5, binaryTree.getRoot().data);
        assertEquals(3, binaryTree.getRoot().left.data);
        assertEquals(7, binaryTree.getRoot().right.data);
        assertEquals(2, binaryTree.getRoot().left.left.data);
        assertEquals(4, binaryTree.getRoot().left.right.data);
        assertEquals(6, binaryTree.getRoot().right.left.data);
        assertEquals(8, binaryTree.getRoot().right.right.data);
    }
}
// ```