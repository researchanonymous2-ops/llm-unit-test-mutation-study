package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayGrok_ZS2Test {

    @Test
    public void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
        assertFalse(stack.isEmpty());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_OnNonFullStack() {
        StackArray stack = new StackArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
        assertFalse(stack.isEmpty());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_OnFullStack() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
        stack.push(3); // Should resize and add
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_AfterResize() {
        StackArray stack = new StackArray(1);
        stack.push(1);
        assertTrue(stack.isFull());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_WithZeroValue() {
        StackArray stack = new StackArray(3);
        stack.push(0);
        assertEquals(1, stack.size());
        assertEquals(0, stack.peek());
    }

    @Test
    public void testPush_WithNegativeValue() {
        StackArray stack = new StackArray(3);
        stack.push(-5);
        assertEquals(1, stack.size());
        assertEquals(-5, stack.peek());
    }
}
// ```