package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayGrok_COC5Test {

    @Test
    public void testPush_WhenNotFull() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_WhenFull() {
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