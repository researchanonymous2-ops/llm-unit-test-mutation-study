package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_POT2Test {

    @Test
    public void testPush_directInsertionWhenNotFull() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        assertEquals(10, stack.peek());
        assertEquals(1, stack.size());
        
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testPush_withResizeWhenFull() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        stack.push(20); // This should trigger a resize
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
        assertFalse(stack.isFull());
    }
}
// ```