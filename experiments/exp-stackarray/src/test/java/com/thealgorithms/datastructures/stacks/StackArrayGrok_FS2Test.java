package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_FS2Test {

   @Test
   void testPush_OnEmptyStack() {
       StackArray stack = new StackArray(5);
       stack.push(10);
       assertFalse(stack.isEmpty());
       assertEquals(1, stack.size());
       assertEquals(10, stack.peek());
   }

   @Test
   void testPush_MultipleElements() {
       StackArray stack = new StackArray(5);
       stack.push(2);
       stack.push(4);
       stack.push(6);
       assertFalse(stack.isEmpty());
       assertEquals(3, stack.size());
       assertEquals(6, stack.peek());
   }

   @Test
   void testPush_TriggersResize() {
       StackArray stack = new StackArray(2);
       stack.push(1);
       stack.push(2);
       stack.push(3);
       assertFalse(stack.isEmpty());
       assertEquals(3, stack.size());
       assertEquals(3, stack.peek());
   }

   @Test
   void testPush_AfterResize() {
       StackArray stack = new StackArray(1);
       stack.push(7);
       stack.push(8);
       stack.push(9);
       stack.push(10);
       assertFalse(stack.isEmpty());
       assertEquals(4, stack.size());
       assertEquals(10, stack.peek());
   }
}
