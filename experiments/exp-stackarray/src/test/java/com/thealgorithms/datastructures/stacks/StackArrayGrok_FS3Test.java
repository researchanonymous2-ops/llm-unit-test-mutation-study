package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_FS3Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_SingleElement() {
        StackArray stack = new StackArray(5);
        stack.push(20);
        assertEquals(1, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    void testPush_MultipleElements() {
        StackArray stack = new StackArray(5);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        assertEquals(3, stack.size());
        assertEquals(50, stack.peek());
    }

    @Test
    void testPush_WhenFull() {
        StackArray stack = new StackArray(2);
        stack.push(60);
        stack.push(70);
        assertTrue(stack.isFull());
        stack.push(80);
        assertFalse(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(80, stack.peek());
    }

    @Test
    void testPush_AfterResize() {
        StackArray stack = new StackArray(1);
        stack.push(90);
        stack.push(100);
        stack.push(110);
        assertEquals(3, stack.size());
        assertEquals(110, stack.peek());
    }

    @Test
    void testPush_LargeNumber() {
        StackArray stack = new StackArray(2);
        for (int i = 0; i < 10; i++) {
            stack.push(i * 10);
        }
        assertEquals(10, stack.size());
        assertEquals(90, stack.peek());
    }
}
// ```