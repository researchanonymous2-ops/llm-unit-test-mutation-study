package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_POT4Test {

    @Test
    public void testPut_inserirNaArvoreVazia() {
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
    public void testPut_inserirMenorQueRaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // Raiz
        tree.put(5);  // Deve ir para a esquerda
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertEquals(root, root.left.parent);
    }

    @Test
    public void testPut_inserirMaiorOuIgualARaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // Raiz
        tree.put(15); // Deve ir para a direita
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertNull(root.right.left);
        assertNull(root.right.right);
        assertEquals(root, root.right.parent);
    }
}
// ```