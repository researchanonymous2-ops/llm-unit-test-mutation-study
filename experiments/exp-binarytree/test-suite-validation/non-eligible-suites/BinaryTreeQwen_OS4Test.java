package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeQwen_OS4Test {

   @Test
   void testPut_rootInsert() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(5));
       assertNotNull(tree.getRoot());
       assertEquals(5, tree.getRoot().data);
   }

   @Test
   void testPut_leftChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(5));
       assertNotNull(tree.getRoot().left);
       assertEquals(5, tree.getRoot().left.data);
   }

   @Test
   void testPut_rightChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       assertDoesNotThrow(() -> tree.put(15));
       assertNotNull(tree.getRoot().right);
       assertEquals(15, tree.getRoot().right.data);
   }

   @Test
   void testPut_multipleValues() {
       BinaryTree tree = new BinaryTree();
       tree.put(20);
       tree.put(10);
       tree.put(30);
       tree.put(5);
       tree.put(15);
       tree.put(25);
       tree.put(35);

       assertNotNull(tree.getRoot());
       assertEquals(20, tree.getRoot().data);
       assertNotNull(tree.getRoot().left);
       assertEquals(10, tree.getRoot().left.data);
       assertNotNull(tree.getRoot().right);
       assertEquals(30, tree.getRoot().right.data);
       assertNotNull(tree.getRoot().left.left);
       assertEquals(5, tree.getRoot().left.left.data);
       assertNotNull(tree.getRoot().left.right);
       assertEquals(15, tree.getRoot().left.right.data);
       assertNotNull(tree.getRoot().right.left);
       assertEquals(25, tree.getRoot().right.left.data);
       assertNotNull(tree.getRoot().right.right);
       assertEquals(35, tree.getRoot().right.right.data);
   }

   @Test
   void testPut_duplicateValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       tree.put(5);
       tree.put(15);
       assertDoesNotThrow(() -> tree.put(5));
       assertNotNull(tree.getRoot().left.left);
       assertEquals(5, tree.getRoot().left.left.data);
   }

   @Test
   void testPut_negativeValues() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(-5));
       assertDoesNotThrow(() -> tree.put(-10));
       assertDoesNotThrow(() -> tree.put(-2));
       
       assertNotNull(tree.getRoot());
       assertEquals(-5, tree.getRoot().data);
       assertNotNull(tree.getRoot().left);
       assertEquals(-10, tree.getRoot().left.data);
       assertNotNull(tree.getRoot().right);
       assertEquals(-2, tree.getRoot().right.data);
   }

   @Test
   void testPut_zeroValue() {
       BinaryTree tree = new BinaryTree();
       assertDoesNotThrow(() -> tree.put(0));
       assertNotNull(tree.getRoot());
       assertEquals(0, tree.getRoot().data);
   }
}
