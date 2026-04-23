package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_OS5Test {

   @Test
   void testPush_OnEmptyStack() {
       StackArray stack = new StackArray(5);
       stack.push(42);
       assertFalse(stack.isEmpty());
       assertEquals(42, stack.peek());
       assertEquals(1, stack.size());
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
       stack.push(10);
       stack.push(20);
       assertTrue(stack.isFull());
       stack.push(30); // Should resize
       assertFalse(stack.isFull());
       assertEquals(30, stack.peek());
       assertEquals(3, stack.size());
   }

   @Test
   void testPush_MultipleValues() {
       StackArray stack = new StackArray(3);
       stack.push(100);
       stack.push(200);
       stack.push(300);
       stack.push(400); // Resize
       assertEquals(400, stack.peek());
       assertEquals(4, stack.size());
   }

   @Test
   void testPush_AfterResize() {
       StackArray stack = new StackArray(1);
       stack.push(5);
       assertTrue(stack.isFull());
       stack.push(15); // Resize to 2
       assertFalse(stack.isFull());
       stack.push(25); // Resize to 4
       assertEquals(25, stack.peek());
       assertEquals(3, stack.size());
   }
}
