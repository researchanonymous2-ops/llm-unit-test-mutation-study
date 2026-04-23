package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_ZS1Test {

    @Test
    public void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(2);
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(5, stack.peek());
    }

    @Test
    public void testPush_OnNonFullStack() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPush_OnFullStack() {
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
    public void testPush_AfterResize() {
        StackArray stack = new StackArray(1);
        stack.push(1);
        assertTrue(stack.isFull());
        stack.push(2);
        assertFalse(stack.isFull());
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.peek());
    }
}
// ```