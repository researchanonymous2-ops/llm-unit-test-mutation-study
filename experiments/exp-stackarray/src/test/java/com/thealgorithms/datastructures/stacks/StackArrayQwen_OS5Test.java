package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_OS5Test {

   @Test
   void testPush_IntoEmptyStack() {
       StackArray stack = new StackArray(3);
       stack.push(42);
       assertFalse(stack.isEmpty());
       assertEquals(1, stack.size());
       assertEquals(42, stack.peek());
   }

   @Test
   void testPush_MultipleElements() {
       StackArray stack = new StackArray(5);
       stack.push(10);
       stack.push(20);
       stack.push(30);
       assertEquals(3, stack.size());
       assertEquals(30, stack.peek());
   }

   @Test
   void testPush_ResizeWhenFull() {
       StackArray stack = new StackArray(2);
       stack.push(1);
       stack.push(2);
       assertTrue(stack.isFull());
       stack.push(3);
       assertEquals(3, stack.size());
       assertEquals(3, stack.peek());
       assertFalse(stack.isFull());
   }

   @Test
   void testPush_NegativeValue() {
       StackArray stack = new StackArray(4);
       stack.push(-5);
       assertEquals(1, stack.size());
       assertEquals(-5, stack.peek());
   }

   @Test
   void testPush_ZeroValue() {
       StackArray stack = new StackArray(1);
       stack.push(0);
       assertEquals(1, stack.size());
       assertEquals(0, stack.peek());
   }

   @Test
   void testPush_MaxIntegerValue() {
       StackArray stack = new StackArray(1);
       stack.push(Integer.MAX_VALUE);
       assertEquals(1, stack.size());
       assertEquals(Integer.MAX_VALUE, stack.peek());
   }

   @Test
   void testPush_MinIntegerValue() {
       StackArray stack = new StackArray(1);
       stack.push(Integer.MIN_VALUE);
       assertEquals(1, stack.size());
       assertEquals(Integer.MIN_VALUE, stack.peek());
   }

   @Test
   void testPush_ToStackThatWasPopped() {
       StackArray stack = new StackArray(3);
       stack.push(100);
       stack.push(200);
       stack.pop();
       stack.push(300);
       assertEquals(2, stack.size());
       assertEquals(300, stack.peek());
   }
}
