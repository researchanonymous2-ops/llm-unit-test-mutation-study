package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_POT5Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(2); // Small capacity to test resizing
    }

    @Test
    public void testPush_directInsertionWhenNotFull() {
        stack.push(10);
        assertFalse(stack.isFull());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());

        stack.push(20);
        assertTrue(stack.isFull());
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    public void testPush_withResizeWhenFull() {
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());

        stack.push(30); // This should trigger a resize and insert successfully

        assertFalse(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }
}
// ```