package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_COC5Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(3);
    }

    @Test
    public void testPush_elementAddedToNonFullStack() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPush_elementAddedAfterResize() {
        stack.push(1);
        stack.push(2);
        stack.push(3); // Stack is now full
        stack.push(4); // Should trigger resize and add element

        assertFalse(stack.isFull());
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());
    }
}
// ```