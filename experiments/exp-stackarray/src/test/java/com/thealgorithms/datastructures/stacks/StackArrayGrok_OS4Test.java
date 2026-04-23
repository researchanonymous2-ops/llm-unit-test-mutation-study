package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_OS4Test {

    @Test
    void testPush_EmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_NotFull() {
        StackArray stack = new StackArray(5);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    void testPush_FullStack() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
        stack.push(3);
        assertFalse(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    void testPush_MultipleValues() {
        StackArray stack = new StackArray(10);
        stack.push(5);
        stack.push(8);
        stack.push(2);
        assertEquals(3, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    void testPush_SizeOne() {
        StackArray stack = new StackArray(1);
        stack.push(42);
        assertTrue(stack.isFull());
        assertEquals(1, stack.size());
        assertEquals(42, stack.peek());
    }
}
// ```