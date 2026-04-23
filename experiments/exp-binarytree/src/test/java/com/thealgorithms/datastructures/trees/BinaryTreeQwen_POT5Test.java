package com.thealgorithms.datastructures.trees;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryTreeQwen_POT5Test {

    @Test
    void testPut_inserirNaArvoreVazia() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.parent);
    }

    @Test
    void testPut_inserirMenorQueRaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // raiz
        tree.put(5);  // filho esquerdo
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNull(root.right);
        assertEquals(root, root.left.parent);
    }

    @Test
    void testPut_inserirMaiorOuIgualARaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // raiz
        tree.put(15); // filho direito
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertNull(root.left);
        assertEquals(root, root.right.parent);
    }
}
// ```