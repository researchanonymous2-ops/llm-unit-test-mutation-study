package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeLlama_OS5Test {

    @Test
    void testPut_SingleValue() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(1));
        assertEquals(1, tree.getRoot().data);
    }

    @Test
    void testPut_MultipleValues() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> {
            tree.put(5);
            tree.put(3);
            tree.put(7);
            tree.put(2);
            tree.put(4);
            tree.put(6);
            tree.put(8);
        });
        assertEquals(5, tree.getRoot().data);
        assertEquals(3, tree.getRoot().left.data);
        assertEquals(7, tree.getRoot().right.data);
        assertEquals(2, tree.getRoot().left.left.data);
        assertEquals(4, tree.getRoot().left.right.data);
        assertEquals(6, tree.getRoot().right.left.data);
        assertEquals(8, tree.getRoot().right.right.data);
    }

    @Test
    void testPut_DuplicateValues() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> {
            tree.put(5);
            tree.put(5);
        });
        assertEquals(5, tree.getRoot().data);
        assertEquals(5, tree.getRoot().right.data);
    }

    @Test
    void testPut_NegativeValues() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> {
            tree.put(-5);
            tree.put(-3);
            tree.put(-7);
        });
        assertEquals(-5, tree.getRoot().data);
        assertEquals(-7, tree.getRoot().left.data);
        assertEquals(-3, tree.getRoot().right.data);
    }

    @Test
    void testPut_Zero() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(0));
        assertEquals(0, tree.getRoot().data);
    }
}
// ```