package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_FS3Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_MultipleElements() {
        StackArray stack = new StackArray(3);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals(40, stack.peek());
    }

    @Test
    void testPush_ResizeWhenFull() {
        StackArray stack = new StackArray(2);
        stack.push(50);
        stack.push(60);
        stack.push(70); // Triggers resize
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertEquals(70, stack.peek());
    }

    @Test
    void testPush_SingleElementOnDefaultCapacity() {
        StackArray stack = new StackArray();
        stack.push(100);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(100, stack.peek());
    }

    @Test
    void testPush_ToFillExactCapacity() {
        StackArray stack = new StackArray(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertTrue(stack.isFull());
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());
    }
}
// ```