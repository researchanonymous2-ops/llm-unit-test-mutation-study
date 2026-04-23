package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayLlama_FS1Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    @Test
    void testPush_MultipleElements() {
        StackArray stack = new StackArray(3);
        stack.push(4);
        stack.push(6);
        stack.push(8);
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals(8, stack.peek());
    }

    @Test
    void testPush_TriggersResizeWhenFull() {
        StackArray stack = new StackArray(1);
        stack.push(5);
        stack.push(9);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(9, stack.peek());
    }

    @Test
    void testPush_OnStackWithDefaultCapacity() {
        StackArray stack = new StackArray();
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_MultipleTimesCausesResize() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }
}
// ```