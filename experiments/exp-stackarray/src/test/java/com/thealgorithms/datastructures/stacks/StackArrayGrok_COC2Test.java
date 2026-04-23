package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackArrayGrok_COC2Test {

    @Test
    void testPush_NotFull() {
        StackArray stack = new StackArray(4);
        stack.push(5);
        stack.push(8);
        assertEquals(2, stack.size());
        assertEquals(8, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    void testPush_Full() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
        assertFalse(stack.isFull());
    }
}
// ```