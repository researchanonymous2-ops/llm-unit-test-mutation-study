package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_COC4Test {

    @Test
    public void testPush_WhenStackIsNotFull_ElementIsAdded() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        assertEquals(10, stack.peek());
        assertEquals(1, stack.size());
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testPush_WhenStackIsFull_ResizeAndAddElement() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        assertTrue(stack.isFull());
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
        assertFalse(stack.isFull());
    }
}
// ```