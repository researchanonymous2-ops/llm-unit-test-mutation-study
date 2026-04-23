package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_COC5Test {

    @Test
    public void testPut_rootIsNull() {
        BinaryTree tree = new BinaryTree();
        tree.put(5);
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    public void testPut_valueLessThanParent() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // root
        tree.put(5);  // left child
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertEquals(root, root.left.parent);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    public void testPut_valueGreaterOrEqualParent() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // root
        tree.put(15); // right child
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertEquals(root, root.right.parent);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }
}
// ```