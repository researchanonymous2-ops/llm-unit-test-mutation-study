package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeLlama_OS2Test {

    @Test
    void testPut_EmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(1));
        assertEquals(1, tree.getRoot().data);
    }

    @Test
    void testPut_SingleNodeTree_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);
        assertDoesNotThrow(() -> tree.put(0));
        assertEquals(0, tree.getRoot().left.data);
    }

    @Test
    void testPut_SingleNodeTree_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);
        assertDoesNotThrow(() -> tree.put(2));
        assertEquals(2, tree.getRoot().right.data);
    }

    @Test
    void testPut_MultipleNodeTree_LeftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(2);
        tree.put(1);
        tree.put(3);
        assertDoesNotThrow(() -> tree.put(0));
        assertEquals(0, tree.getRoot().left.left.data);
    }

    @Test
    void testPut_MultipleNodeTree_RightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(2);
        tree.put(1);
        tree.put(3);
        assertDoesNotThrow(() -> tree.put(4));
        assertEquals(4, tree.getRoot().right.right.data);
    }

    @Test
    void testPut_DuplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);
        assertDoesNotThrow(() -> tree.put(1));
        assertEquals(1, tree.getRoot().data);
        assertEquals(1, tree.getRoot().right.data);
    }
}
// ```