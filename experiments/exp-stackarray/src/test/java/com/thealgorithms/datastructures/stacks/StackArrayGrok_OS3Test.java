package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_OS3Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(10, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testPush_OnNonFullStack() {
        StackArray stack = new StackArray(5);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    void testPush_OnFullStack() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
        stack.push(3); // Should resize
        assertFalse(stack.isFull());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    void testPush_AfterResize() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());
    }

    @Test
    void testPush_MultipleValues() {
        StackArray stack = new StackArray(10);
        stack.push(5);
        stack.push(15);
        stack.push(25);
        assertEquals(3, stack.size());
        assertEquals(25, stack.peek());
    }

    @Test
    void testPush_ZeroValue() {
        StackArray stack = new StackArray(5);
        stack.push(0);
        assertEquals(0, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testPush_NegativeValue() {
        StackArray stack = new StackArray(5);
        stack.push(-5);
        assertEquals(-5, stack.peek());
        assertEquals(1, stack.size());
    }
}
// ```