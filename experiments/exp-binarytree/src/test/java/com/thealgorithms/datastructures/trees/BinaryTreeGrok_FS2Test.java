package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_FS2Test {

   @Test
   void testPut_InsertIntoEmptyTree() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(15));
   }

   @Test
   void testPut_InsertSmallerThanRoot() {
       BinaryTree tree = new BinaryTree();
       tree.put(20);
       assertDoesNotThrow(() -> tree.put(10));
   }

   @Test
   void testPut_InsertLargerThanRoot() {
       BinaryTree tree = new BinaryTree();
       tree.put(20);
       assertDoesNotThrow(() -> tree.put(30));
   }

   @Test
   void testPut_InsertDuplicateValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(25);
       assertDoesNotThrow(() -> tree.put(25));
   }

   @Test
   void testPut_InsertDeepLeft() {
       BinaryTree tree = new BinaryTree();
       tree.put(50);
       tree.put(30);
       tree.put(20);
       assertDoesNotThrow(() -> tree.put(15));
   }

   @Test
   void testPut_InsertDeepRight() {
       BinaryTree tree = new BinaryTree();
       tree.put(50);
       tree.put(70);
       tree.put(80);
       assertDoesNotThrow(() -> tree.put(90));
   }

   @Test
   void testPut_InsertMixedValues() {
       BinaryTree tree = new BinaryTree();
       tree.put(40);
       tree.put(20);
       tree.put(60);
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(50));
   }
}
