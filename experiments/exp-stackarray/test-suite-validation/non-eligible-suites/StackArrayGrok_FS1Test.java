package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_FS1Test {

   @Test
   void testPush_OnEmptyStack() {
       StackArray stack = new StackArray(5);
       stack.push(10);
       assertFalse(stack.isEmpty());
       assertEquals(1, stack.size());
       assertEquals(10, stack.peek());
   }

   @Test
   void testPush_OnNonFullStack() {
       StackArray stack = new StackArray(5);
       stack.push(20);
       stack.push(30);
       assertFalse(stack.isEmpty());
       assertEquals(2, stack.size());
       assertEquals(30, stack.peek());
   }

   @Test
   void testPush_OnFullStack() {
       StackArray stack = new StackArray(2);
       stack.push(40);
       stack.push(50);
       assertTrue(stack.isFull());
       stack.push(60);
       assertFalse(stack.isFull());
       assertEquals(3, stack.size());
       assertEquals(60, stack.peek());
   }

   @Test
   void testPush_MultipleElements() {
       StackArray stack = new StackArray(3);
       stack.push(70);
       stack.push(80);
       stack.push(90);
       stack.push(100);
       assertEquals(4, stack.size());
       assertEquals(100, stack.peek());
   }

   @Test
   void testPush_WithResize() {
       StackArray stack = new StackArray(1);
       stack.push(110);
       assertTrue(stack.isFull());
       stack.push(120);
       assertFalse(stack.isFull());
       assertEquals(2, stack.size());
       assertEquals(120, stack.peek());
   }
}
