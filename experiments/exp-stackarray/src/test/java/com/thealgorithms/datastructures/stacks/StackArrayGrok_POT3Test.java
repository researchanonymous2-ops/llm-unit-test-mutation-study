package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_POT3Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(2);
    }

    @Test
    void testPush_WhenNotFull() {
        // Push when stack is not full
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());

        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    void testPush_WhenFull() {
        // Fill the stack
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());

        // Push when full, should resize
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }
}
// ```