package com.thealgorithms.datastructures.trees;

package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeGrok_ZS4Test {

   @Test
   public void testPut_EmptyTree() {
       BinaryTree tree = new BinaryTree();
       tree.put(5);
       assertNotNull(tree.getRoot());
       assertEquals(5, tree.getRoot().data);
       assertNull(tree.getRoot().left);
       assertNull(tree.getRoot().right);
   }

   @Test
   public void testPut_LeftChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(5);
       tree.put(3);
       assertNotNull(tree.getRoot().left);
       assertEquals(3, tree.getRoot().left.data);
       assertNull(tree.getRoot().right);
   }

   @Test
   public void testPut_RightChild() {
       BinaryTree tree = new BinaryTree();
       tree.put(5);
       tree.put(7);
       assertNotNull(tree.getRoot().right);
       assertEquals(7, tree.getRoot().right.data);
       assertNull(tree.getRoot().left);
   }

   @Test
   public void testPut_Duplicate() {
       BinaryTree tree = new BinaryTree();
       tree.put(5);
       tree.put(5);
       assertNotNull(tree.getRoot().right);
       assertEquals(5, tree.getRoot().right.data);
   }

   @Test
   public void testPut_MultipleInserts() {
       BinaryTree tree = new BinaryTree();
       tree.put(5);
       tree.put(3);
       tree.put(7);
       tree.put(2);
       tree.put(4);
       assertEquals(5, tree.getRoot().data);
       assertEquals(3, tree.getRoot().left.data);
       assertEquals(7, tree.getRoot().right.data);
       assertEquals(2, tree.getRoot().left.left.data);
       assertEquals(4, tree.getRoot().left.right.data);
   }
}
