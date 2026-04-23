package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_POT1Test {

    @Test
    public void testPut_inserirNaArvoreVazia() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().data);
        assertNull(tree.getRoot().left);
        assertNull(tree.getRoot().right);
        assertNull(tree.getRoot().parent);
    }

    @Test
    public void testPut_inserirMenorQueRaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // Raiz
        tree.put(5);  // Deve ir para a esquerda
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNull(root.right);
        assertEquals(root, root.left.parent);
    }

    @Test
    public void testPut_inserirMaiorOuIgualARaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // Raiz
        tree.put(15); // Deve ir para a direita
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNull(root.left);
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        assertEquals(root, root.right.parent);
    }
}
// ```