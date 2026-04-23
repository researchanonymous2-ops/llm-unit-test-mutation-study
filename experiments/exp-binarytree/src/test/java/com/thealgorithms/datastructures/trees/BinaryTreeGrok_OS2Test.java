package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_OS2Test {

   @Test
   void testPut_EmptyTree() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(5));
       assertNotNull(tree.getRoot());
       assertEquals(5, tree.getRoot().data);
   }

   @Test
   void testPut_LeftChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(5));
       assertEquals(5, tree.getRoot().left.data);
   }

   @Test
   void testPut_RightChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(15));
       assertEquals(15, tree.getRoot().right.data);
   }

   @Test
   void testPut_DuplicateValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(10));
       assertEquals(10, tree.getRoot().right.data);
   }

   @Test
   void testPut_MultipleInserts() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> {
           tree.put(20);
           tree.put(10);
           tree.put(30);
           tree.put(5);
           tree.put(15);
       });
       assertNotNull(tree.getRoot());
       assertEquals(20, tree.getRoot().data);
       assertEquals(10, tree.getRoot().left.data);
       assertEquals(30, tree.getRoot().right.data);
   }

   @Test
   void testPut_NegativeValue() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(-5));
       assertEquals(-5, tree.getRoot().data);
   }

   @Test
   void testPut_ZeroValue() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(0));
       assertEquals(0, tree.getRoot().data);
   }
}
