package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_OS2Test {

    @Test
    void testPush_OnEmptyStack() {
        StackArray stack = new StackArray(5);
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(42, stack.peek());
    }

    @Test
    void testPush_OnNonFullStack() {
        StackArray stack = new StackArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    void testPush_OnFullStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());
        stack.push(30);
        assertFalse(stack.isFull());
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    void testPush_MultipleValues() {
        StackArray stack = new StackArray(3);
        stack.push(100);
        stack.push(200);
        stack.push(300);
        assertEquals(3, stack.size());
        assertEquals(300, stack.peek());
    }

    @Test
    void testPush_AfterResize() {
        StackArray stack = new StackArray(1);
        stack.push(5);
        assertTrue(stack.isFull());
        stack.push(15);
        stack.push(25);
        assertEquals(3, stack.size());
        assertEquals(25, stack.peek());
    }
}
// ```