package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeGrok_OS1Test {

   @Test
   void testPut_EmptyTree() {
       BinaryTree tree = new BinaryTree();
       tree.put(5);
       assertNotNull(tree.getRoot());
       assertEquals(5, tree.getRoot().data);
   }

   @Test
   void testPut_LeftChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       tree.put(5);
       assertNotNull(tree.getRoot().left);
       assertEquals(5, tree.getRoot().left.data);
       assertEquals(tree.getRoot(), tree.getRoot().left.parent);
   }

   @Test
   void testPut_RightChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       tree.put(15);
       assertNotNull(tree.getRoot().right);
       assertEquals(15, tree.getRoot().right.data);
       assertEquals(tree.getRoot(), tree.getRoot().right.parent);
   }

   @Test
   void testPut_DuplicateValue() {
       BinaryTree tree = new BinaryTree();
       tree.put(10);
       tree.put(10);
       assertNotNull(tree.getRoot().right);
       assertEquals(10, tree.getRoot().right.data);
       assertEquals(tree.getRoot(), tree.getRoot().right.parent);
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
       assertEquals(5, tree.getRoot().left.left.data);
       assertEquals(15, tree.getRoot().left.right.data);
   }

   @Test
   void testPut_FindAfterInsert() {
       BinaryTree tree = new BinaryTree();
       tree.put(7);
       tree.put(3);
       tree.put(11);
       BinaryTree.Node found = tree.find(3);
       assertNotNull(found);
       assertEquals(3, found.data);
   }
}
