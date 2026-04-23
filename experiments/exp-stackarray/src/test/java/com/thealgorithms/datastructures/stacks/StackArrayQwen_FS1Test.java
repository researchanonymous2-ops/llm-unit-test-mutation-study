package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_FS1Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_ToFillCapacity() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    void testPush_WhenStackIsFullTriggersResize() {
        StackArray stack = new StackArray(2);
        stack.push(50);
        stack.push(60);
        stack.push(70); // Should trigger resize
        assertFalse(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(70, stack.peek());
    }

    @Test
    void testPush_AfterResizeMaintainsOrder() {
        StackArray stack = new StackArray(1);
        stack.push(5);
        stack.push(15);
        stack.push(25);
        assertEquals(25, stack.pop());
        assertEquals(15, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    void testPush_NegativeValue() {
        StackArray stack = new StackArray(4);
        stack.push(-5);
        assertFalse(stack.isEmpty());
        assertEquals(-5, stack.peek());
    }

    @Test
    void testPush_ZeroValue() {
        StackArray stack = new StackArray(2);
        stack.push(0);
        assertEquals(0, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testPush_SameValues() {
        StackArray stack = new StackArray(3);
        stack.push(7);
        stack.push(7);
        stack.push(7);
        assertEquals(7, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(7, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPush_LargeValue() {
        StackArray stack = new StackArray(1);
        stack.push(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, stack.peek());
        assertEquals(1, stack.size());
    }
}
// ```