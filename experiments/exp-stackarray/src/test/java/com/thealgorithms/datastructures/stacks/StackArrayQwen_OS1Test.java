package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayQwen_OS1Test {

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
        stack.push(100);
        stack.push(200);
        assertTrue(stack.isFull());
        stack.push(300); // Should trigger resize
        assertEquals(3, stack.size());
        assertEquals(300, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    void testPush_afterResize_preservesOrder() {
        StackArray stack = new StackArray(2);
        stack.push(11);
        stack.push(22);
        stack.push(33); // Triggers resize
        stack.push(44);
        assertEquals(4, stack.size());
        assertEquals(44, stack.pop());
        assertEquals(33, stack.pop());
        assertEquals(22, stack.pop());
        assertEquals(11, stack.pop());
    }

    @Test
    void testPush_singleElementOnDefaultCapacity() {
        StackArray stack = new StackArray();
        stack.push(7);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(7, stack.peek());
    }
}
// ```