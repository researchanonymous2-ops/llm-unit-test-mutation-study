package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_COC4Test {

    @Test
    public void testPush_NotFull() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        assertEquals(1, stack.peek());
        assertEquals(1, stack.size());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_Full() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
        assertFalse(stack.isFull());
    }
}
// ```