package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeQwen_OS2Test {

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
       assertEquals(5, tree.getRoot().left.data);
       assertEquals(tree.getRoot(), tree.getRoot().left.parent);
   }

   @Test
   void testPut_rightChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(15));
       assertEquals(15, tree.getRoot().right.data);
       assertEquals(tree.getRoot(), tree.getRoot().right.parent);
   }

   @Test
   void testPut_duplicateValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(10));
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
       assertDoesNotThrow(() -> tree.put(25));
       assertDoesNotThrow(() -> tree.put(35));

       assertNotNull(tree.getRoot());
       assertEquals(20, tree.getRoot().data);

       assertNotNull(tree.getRoot().left);
       assertEquals(10, tree.getRoot().left.data);
       assertEquals(tree.getRoot(), tree.getRoot().left.parent);

       assertNotNull(tree.getRoot().right);
       assertEquals(30, tree.getRoot().right.data);
       assertEquals(tree.getRoot(), tree.getRoot().right.parent);

       assertNotNull(tree.getRoot().left.left);
       assertEquals(5, tree.getRoot().left.left.data);
       assertEquals(tree.getRoot().left, tree.getRoot().left.left.parent);

       assertNotNull(tree.getRoot().left.right);
       assertEquals(15, tree.getRoot().left.right.data);
       assertEquals(tree.getRoot().left, tree.getRoot().left.right.parent);

       assertNotNull(tree.getRoot().right.left);
       assertEquals(25, tree.getRoot().right.left.data);
       assertEquals(tree.getRoot().right, tree.getRoot().right.left.parent);

       assertNotNull(tree.getRoot().right.right);
       assertEquals(35, tree.getRoot().right.right.data);
       assertEquals(tree.getRoot().right, tree.getRoot().right.right.parent);
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
