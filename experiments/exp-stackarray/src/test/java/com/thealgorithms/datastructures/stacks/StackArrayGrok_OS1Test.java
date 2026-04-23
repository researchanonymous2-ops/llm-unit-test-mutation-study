package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_OS1Test {

   @Test
   void testPush_OnEmptyStack() {
       StackArray stack = new StackArray(5);
       stack.push(42);
       assertFalse(stack.isEmpty());
       assertEquals(1, stack.size());
       assertEquals(42, stack.peek());
   }

   @Test
   void testPush_OnNonFullStack() {
       StackArray stack = new StackArray(5);
       stack.push(1);
       stack.push(2);
       stack.push(3);
       assertEquals(3, stack.size());
       assertEquals(3, stack.peek());
   }

   @Test
   void testPush_OnFullStack() {
       StackArray stack = new StackArray(2);
       stack.push(1);
       stack.push(2);
       assertTrue(stack.isFull());
       stack.push(3);
       assertFalse(stack.isFull());
       assertEquals(3, stack.size());
       assertEquals(3, stack.peek());
   }

   @Test
   void testPush_MultiplePushesWithResize() {
       StackArray stack = new StackArray(1);
       stack.push(10);
       assertTrue(stack.isFull());
       stack.push(20);
       stack.push(30);
       assertEquals(3, stack.size());
       assertEquals(30, stack.peek());
   }

   @Test
   void testPush_DefaultCapacity() {
       StackArray stack = new StackArray();
       for (int i = 0; i < 10; i++) {
           stack.push(i);
       }
       assertTrue(stack.isFull());
       stack.push(10);
       assertFalse(stack.isFull());
       assertEquals(11, stack.size());
       assertEquals(10, stack.peek());
   }
}
