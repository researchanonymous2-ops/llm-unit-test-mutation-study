package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayLlama_ZS5Test {

    @Test
    public void testPush_EmptyStack() {
        StackArray stack = new StackArray(5);
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPush_NonEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertEquals(1, stack.size());
        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    public void testPush_FullStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());
        stack.push(30);
        assertFalse(stack.isFull()); // Because it resizes
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPush_MultipleTimes() {
        StackArray stack = new StackArray(5);
        for (int i = 1; i <= 5; i++) {
            stack.push(i * 10);
            assertEquals(i, stack.size());
            assertEquals(i * 10, stack.peek());
        }
    }
}
// ```