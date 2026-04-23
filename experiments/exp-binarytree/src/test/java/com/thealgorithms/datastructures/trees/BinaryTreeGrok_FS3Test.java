package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_FS3Test {

   @Test
   void testPut_EmptyTree() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(15));
   }

   @Test
   void testPut_SingleValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(25));
   }

   @Test
   void testPut_LeftChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(20);
       assertDoesNotThrow(() -> tree.put(5));
   }

   @Test
   void testPut_RightChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(30);
       assertDoesNotThrow(() -> tree.put(40));
   }

   @Test
   void testPut_MultipleInserts() {
       BinaryTree tree = new BinaryTree();
       tree.put(50);
       tree.put(30);
       assertDoesNotThrow(() -> tree.put(70));
   }

   @Test
   void testPut_DuplicateValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(100);
       assertDoesNotThrow(() -> tree.put(100));
   }

   @Test
   void testPut_NegativeValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(0);
       assertDoesNotThrow(() -> tree.put(-10));
   }

   @Test
   void testPut_LargeValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(1);
       assertDoesNotThrow(() -> tree.put(1000));
   }
}
