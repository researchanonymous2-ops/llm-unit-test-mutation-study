package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayLlama_ZS2Test {

    @Test
    public void testPush_Element() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPush_MultipleElements() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPush_FullStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());
        stack.push(30);
        assertEquals(3, stack.size());
        assertFalse(stack.isFull()); // Because it resizes
    }

    @Test
    public void testPush_EmptyStack() {
        StackArray stack = new StackArray(5);
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPush_DefaultCapacity() {
        StackArray stack = new StackArray();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
    }
}
// ```