package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_FS4Test {

   @Test
   void testPush_OnEmptyStack() {
       StackArray stack = new StackArray(5);
       stack.push(10);
       assertFalse(stack.isEmpty());
       assertEquals(10, stack.peek());
       assertEquals(1, stack.size());
   }

   @Test
   void testPush_OnNonFullStack() {
       StackArray stack = new StackArray(5);
       stack.push(20);
       stack.push(30);
       assertFalse(stack.isEmpty());
       assertEquals(30, stack.peek());
       assertEquals(2, stack.size());
   }

   @Test
   void testPush_OnFullStack() {
       StackArray stack = new StackArray(1);
       stack.push(40);
       assertTrue(stack.isFull());
       stack.push(50);
       assertFalse(stack.isFull());
       assertEquals(50, stack.peek());
       assertEquals(2, stack.size());
   }

   @Test
   void testPush_MultipleElements() {
       StackArray stack = new StackArray(2);
       stack.push(60);
       stack.push(70);
       stack.push(80);
       assertEquals(80, stack.peek());
       assertEquals(3, stack.size());
   }

   @Test
   void testPush_AfterResize() {
       StackArray stack = new StackArray(1);
       stack.push(90);
       stack.push(100);
       stack.push(110);
       assertEquals(110, stack.peek());
       assertEquals(3, stack.size());
   }
}
