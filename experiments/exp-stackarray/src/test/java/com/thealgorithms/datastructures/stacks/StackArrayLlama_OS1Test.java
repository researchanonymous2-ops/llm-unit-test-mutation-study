package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayLlama_OS1Test {

    @Test
    void testPush_EmptyStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void testPush_NotFullStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertTrue(stack.isFull());
    }

    @Test
    void testPush_FullStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertFalse(stack.isFull());
        assertEquals(30, stack.peek());
    }

    @Test
    void testPush_MultipleTimes() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        assertEquals(6, stack.size());
        assertEquals(60, stack.peek());
    }
}
// ```