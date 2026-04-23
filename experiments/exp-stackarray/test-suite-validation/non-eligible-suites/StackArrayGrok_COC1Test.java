package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_COC1Test {

    @Test
    void testPush_NotFull() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        assertEquals(0, stack.top);
        assertEquals(1, stack.peek());
        assertEquals(1, stack.size());
        assertFalse(stack.isFull());
    }

    @Test
    void testPush_Full() {
        StackArray stack = new StackArray(1);
        stack.push(1);
        assertTrue(stack.isFull());
        assertEquals(0, stack.top);
        assertEquals(1, stack.peek());
        stack.push(2);
        assertEquals(1, stack.top);
        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
        assertEquals(2, stack.maxSize);
        assertTrue(stack.isFull());
    }
}
// ```