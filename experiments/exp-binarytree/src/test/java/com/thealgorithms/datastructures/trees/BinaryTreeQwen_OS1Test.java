package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeQwen_OS1Test {

    @Test
    void testPut_rootIsNull() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(10));
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
    }

    @Test
    void testPut_leftChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(5));
        assertNotNull(tree.getRoot().left);
        assertEquals(5, tree.getRoot().left.data);
        assertEquals(tree.getRoot(), tree.getRoot().left.parent);
    }

    @Test
    void testPut_rightChild() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(15));
        assertNotNull(tree.getRoot().right);
        assertEquals(15, tree.getRoot().right.data);
        assertEquals(tree.getRoot(), tree.getRoot().right.parent);
    }

    @Test
    void testPut_duplicateValue() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(10));
        assertNotNull(tree.getRoot().right);
        assertEquals(10, tree.getRoot().right.data);
        assertEquals(tree.getRoot(), tree.getRoot().right.parent);
    }

    @Test
    void testPut_multipleValues() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(20));
        assertDoesNotThrow(() -> tree.put(10));
        assertDoesNotThrow(() -> tree.put(30));
        assertDoesNotThrow(() -> tree.put(5));
        assertDoesNotThrow(() -> tree.put(15));
        
        assertNotNull(tree.getRoot());
        assertEquals(20, tree.getRoot().data);
        
        assertNotNull(tree.getRoot().left);
        assertEquals(10, tree.getRoot().left.data);
        
        assertNotNull(tree.getRoot().right);
        assertEquals(30, tree.getRoot().right.data);
        
        assertNotNull(tree.getRoot().left.left);
        assertEquals(5, tree.getRoot().left.left.data);
        
        assertNotNull(tree.getRoot().left.right);
        assertEquals(15, tree.getRoot().left.right.data);
    }

    @Test
    void testPut_negativeValue() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(-5));
        assertNotNull(tree.getRoot());
        assertEquals(-5, tree.getRoot().data);
    }

    @Test
    void testPut_zeroValue() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(0));
        assertNotNull(tree.getRoot());
        assertEquals(0, tree.getRoot().data);
    }
}
// ```