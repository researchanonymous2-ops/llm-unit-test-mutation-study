package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_POT4Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(2); // Small size to test resize
    }

    @Test
    void testPush_WhenNotFull() {
        // P1: Inserção direta quando a pilha não está cheia
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    void testPush_WhenFull() {
        // P2: Inserção após redimensionamento quando a pilha está cheia
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());
        stack.push(30); // Should resize and push
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
        assertFalse(stack.isFull());
    }
}
// ```