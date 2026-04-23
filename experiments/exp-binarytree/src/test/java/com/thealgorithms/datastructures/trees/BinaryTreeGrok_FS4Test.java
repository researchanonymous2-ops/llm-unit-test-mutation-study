package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_FS4Test {

   @Test
   void testPut_InsertIntoEmptyTree() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(15));
   }

   @Test
   void testPut_InsertSmallerThanRoot() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(10));
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
   void testPut_InsertMultipleValues() {
       BinaryTree tree = new BinaryTree();
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(10));
       assertDoesNotThrow(() -> tree.put(25));
       assertDoesNotThrow(() -> tree.put(5));
       assertDoesNotThrow(() -> tree.put(20));
   }

   @Test
   void testPut_InsertNegativeValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(0);
       assertDoesNotThrow(() -> tree.put(-5));
   }

   @Test
   void testPut_InsertZero() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(0));
   }
}
