package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeLlama_OS1Test {

    @Test
    void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(1));
        assertEquals(1, tree.getRoot().data);
    }

    @Test
    void testPut_SingleNodeTree_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        assertDoesNotThrow(() -> tree.put(3));
        assertEquals(3, tree.getRoot().left.data);
    }

    @Test
    void testPut_SingleNodeTree_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        assertDoesNotThrow(() -> tree.put(7));
        assertEquals(7, tree.getRoot().right.data);
    }

    @Test
    void testPut_MultipleNodeTree_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(7);
        tree.put(3);
        tree.put(4);
        assertDoesNotThrow(() -> tree.put(2));
        assertEquals(2, tree.getRoot().left.left.data);
    }

    @Test
    void testPut_MultipleNodeTree_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        tree.put(3);
        tree.put(7);
        tree.put(6);
        assertDoesNotThrow(() -> tree.put(8));
        assertEquals(8, tree.getRoot().right.right.data);
    }

    @Test
    void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        assertDoesNotThrow(() -> tree.put(5));
        assertEquals(5, tree.getRoot().right.data);
    }
}
// ```