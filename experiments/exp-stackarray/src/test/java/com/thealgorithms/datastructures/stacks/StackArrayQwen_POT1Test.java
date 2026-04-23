package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_POT1Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(2);
    }

    @Test
    public void testPush_directInsertionWhenNotFull() {
        stack.push(10);
        assertEquals(10, stack.peek());
        assertEquals(1, stack.size());

        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testPush_withResizeWhenFull() {
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());

        stack.push(30); // Triggers resize and inserts
        assertEquals(30, stack.peek());
        assertEquals(3, stack.size());
        assertFalse(stack.isFull());
    }
}
// ```