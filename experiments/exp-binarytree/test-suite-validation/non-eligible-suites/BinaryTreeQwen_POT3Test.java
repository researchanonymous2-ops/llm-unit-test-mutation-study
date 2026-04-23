package com.thealgorithms.datastructures.trees;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeQwen_POT3Test {

    @Test
    public void testPut_insercaoEmArvoreVazia() {
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
    public void testPut_insercaoDeValorMenorQueRaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // root
        tree.put(5);  // left child
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNotNull(root.left);
        assertEquals(5, root.left.data);
        assertNull(root.right);
        assertEquals(root, root.left.parent);
    }

    @Test
    public void testPut_insercaoDeValorMaiorOuIgualARaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10); // root
        tree.put(15); // right child
        tree.put(10); // right child (igual, vai para a direita)
        
        BinaryTree.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.data);
        assertNull(root.left);
        assertNotNull(root.right);
        assertEquals(15, root.right.data);
        
        BinaryTree.Node secondRight = root.right.right;
        assertNotNull(secondRight);
        assertEquals(10, secondRight.data);
        assertEquals(root.right, secondRight.parent);
    }
}
// ```