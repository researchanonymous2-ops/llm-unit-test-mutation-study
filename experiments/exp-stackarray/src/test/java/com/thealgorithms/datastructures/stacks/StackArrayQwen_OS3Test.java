package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_OS3Test {

    @Test
    void testPush_onEmptyStack() {
        StackArray stack = new StackArray(3);
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(42, stack.peek());
    }

    @Test
    void testPush_multipleElements() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    void testPush_toFullStack_triggersResize() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    void testPush_singleElementOnDefaultCapacityStack() {
        StackArray stack = new StackArray();
        stack.push(7);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(7, stack.peek());
    }

    @Test
    void testPush_whenStackBecomesFull() {
        StackArray stack = new StackArray(2);
        stack.push(100);
        stack.push(200);
        assertTrue(stack.isFull());
        assertEquals(2, stack.size());
        assertEquals(200, stack.peek());
    }
}
// ```