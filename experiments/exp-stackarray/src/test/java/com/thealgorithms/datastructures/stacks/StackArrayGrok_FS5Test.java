package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_FS5Test {

   @Test
   void testPush_OnEmptyStack() {
       StackArray stack = new StackArray(5);
       stack.push(10);
       assertFalse(stack.isEmpty());
       assertEquals(1, stack.size());
       assertEquals(10, stack.peek());
   }

   @Test
   void testPush_MultipleElementsWithoutResize() {
       StackArray stack = new StackArray(5);
       stack.push(20);
       stack.push(30);
       stack.push(40);
       assertFalse(stack.isEmpty());
       assertEquals(3, stack.size());
       assertEquals(40, stack.peek());
   }

   @Test
   void testPush_TriggersResize() {
       StackArray stack = new StackArray(2);
       stack.push(50);
       stack.push(60);
       stack.push(70); // This should trigger resize
       assertFalse(stack.isEmpty());
       assertEquals(3, stack.size());
       assertEquals(70, stack.peek());
       assertFalse(stack.isFull()); // After resize, should not be full
   }

   @Test
   void testPush_AfterResize() {
       StackArray stack = new StackArray(1);
       stack.push(80);
       stack.push(90); // Resize happens here
       stack.push(100); // Push after resize
       assertEquals(3, stack.size());
       assertEquals(100, stack.peek());
   }

   @Test
   void testPush_SingleElement() {
       StackArray stack = new StackArray(3);
       stack.push(15);
       assertEquals(1, stack.size());
       assertEquals(15, stack.peek());
       assertFalse(stack.isFull());
   }
}
