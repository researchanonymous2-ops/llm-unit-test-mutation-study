package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_FS5Test {

    @Test
    void testPush_OnEmptyStackIncrementsSize() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void testPush_AddsElementToTop() {
        StackArray stack = new StackArray(5);
        stack.push(20);
        assertEquals(20, stack.peek());
    }

    @Test
    void testPush_MultipleElementsMaintainsOrder() {
        StackArray stack = new StackArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    void testPush_WhenFullTriggersResizeAndAddsElement() {
        StackArray stack = new StackArray(1);
        stack.push(50);
        stack.push(60);
        assertFalse(stack.isFull());
        assertEquals(2, stack.size());
        assertEquals(60, stack.peek());
    }

    @Test
    void testPush_AfterResizeStillPushesCorrectly() {
        StackArray stack = new StackArray(2);
        stack.push(100);
        stack.push(200);
        stack.push(300); // triggers resize
        stack.push(400);
        assertEquals(4, stack.size());
        assertEquals(400, stack.peek());
    }

    @Test
    void testPush_NegativeValueHandledCorrectly() {
        StackArray stack = new StackArray(3);
        stack.push(-5);
        assertFalse(stack.isEmpty());
        assertEquals(-5, stack.peek());
    }

    @Test
    void testPush_ZeroValueHandledCorrectly() {
        StackArray stack = new StackArray(3);
        stack.push(0);
        assertFalse(stack.isEmpty());
        assertEquals(0, stack.peek());
    }

    @Test
    void testPush_MaxIntegerValueHandledCorrectly() {
        StackArray stack = new StackArray(3);
        stack.push(Integer.MAX_VALUE);
        assertFalse(stack.isEmpty());
        assertEquals(Integer.MAX_VALUE, stack.peek());
    }
}
// ```