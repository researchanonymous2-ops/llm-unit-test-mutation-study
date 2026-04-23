package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayLlama_OS5Test {

    @Test
    void testPush_EmptyStack() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_FullStack() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        assertEquals(1, stack.size());
        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    void testPush_MultipleElements() {
        StackArray stack = new StackArray(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    void testPush_Resize() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }
}
// ```