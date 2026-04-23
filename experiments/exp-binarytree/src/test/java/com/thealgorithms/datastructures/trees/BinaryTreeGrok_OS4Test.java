package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_OS4Test {

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
       assertEquals(5, tree.find(5).data);
       assertEquals(10, tree.getRoot().data);
   }

   @Test
   void testPut_RightChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(15));
       assertEquals(15, tree.find(15).data);
       assertEquals(10, tree.getRoot().data);
   }

   @Test
   void testPut_Duplicate() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(10));
       assertEquals(10, tree.find(10).data);
   }

   @Test
   void testPut_MultipleValues() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(20));
       assertDoesNotThrow(() -> tree.put(10));
       assertDoesNotThrow(() -> tree.put(30));
       assertDoesNotThrow(() -> tree.put(5));
       assertDoesNotThrow(() -> tree.put(15));
       assertEquals(20, tree.getRoot().data);
       assertEquals(10, tree.find(10).data);
       assertEquals(30, tree.find(30).data);
       assertEquals(5, tree.find(5).data);
       assertEquals(15, tree.find(15).data);
   }

   @Test
   void testPut_NegativeValue() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(-5));
       assertEquals(-5, tree.getRoot().data);
   }

   @Test
   void testPut_Zero() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(0));
       assertEquals(0, tree.getRoot().data);
   }
}
