package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_FS4Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void testPush_ToFillCapacity() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    void testPush_TriggerResize() {
        StackArray stack = new StackArray(2);
        stack.push(5);
        stack.push(10);
        stack.push(15); // Should trigger resize
        assertFalse(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(15, stack.peek());
    }

    @Test
    void testPush_AfterResizeMaintainsOrder() {
        StackArray stack = new StackArray(1);
        stack.push(100);
        stack.push(200);
        stack.push(300);
        assertEquals(300, stack.pop());
        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());
    }

    @Test
    void testPush_MultipleResizes() {
        StackArray stack = new StackArray(1);
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.size());
        assertEquals(10, stack.peek());
        assertFalse(stack.isEmpty());
    }
}
// ```