package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_FS2Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_ToFillStack() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    void testPush_WhenStackIsFullThenResizes() {
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
        stack.push(35);
        assertEquals(4, stack.size());
        assertEquals(35, stack.peek());
        stack.pop();
        assertEquals(25, stack.peek());
    }

    @Test
    void testPush_NegativeValue() {
        StackArray stack = new StackArray(4);
        stack.push(-5);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(-5, stack.peek());
    }

    @Test
    void testPush_ZeroValue() {
        StackArray stack = new StackArray(2);
        stack.push(0);
        assertEquals(1, stack.size());
        assertEquals(0, stack.peek());
    }

    @Test
    void testPush_SameValues() {
        StackArray stack = new StackArray(3);
        stack.push(7);
        stack.push(7);
        stack.push(7);
        assertEquals(3, stack.size());
        assertEquals(7, stack.peek());
        stack.pop();
        assertEquals(7, stack.peek());
    }

    @Test
    void testPush_LargeCapacityStack() {
        StackArray stack = new StackArray(1000);
        stack.push(999);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(999, stack.peek());
    }
}
// ```