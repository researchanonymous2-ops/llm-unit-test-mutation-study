package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_FS1Test {

   @Test
   void testPut_EmptyTree() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(15));
   }

   @Test
   void testPut_InsertSmallerThanRoot() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(7));
   }

   @Test
   void testPut_InsertLargerThanRoot() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(25));
   }

   @Test
   void testPut_InsertEqualToRoot() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(15));
   }

   @Test
   void testPut_MultipleInserts() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       tree.put(7);
       tree.put(25);
       assertDoesNotThrow(() -> tree.put(12));
   }

   @Test
   void testPut_InsertNegativeValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(-5));
   }

   @Test
   void testPut_InsertZero() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(0));
   }

   @Test
   void testPut_InsertAfterMultiple() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       tree.put(7);
       tree.put(25);
       tree.put(12);
       assertDoesNotThrow(() -> tree.put(30));
   }

   @Test
   void testPut_InsertLeftOfLeft() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       tree.put(7);
       assertDoesNotThrow(() -> tree.put(3));
   }

   @Test
   void testPut_InsertRightOfRight() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       tree.put(25);
       assertDoesNotThrow(() -> tree.put(35));
   }
}
