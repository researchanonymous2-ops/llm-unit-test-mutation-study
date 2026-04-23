package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.datastructures.stacks.StackArray;

public class StackArrayGrok_COC3Test {

    @Test
    public void testPush_NotFull() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_Full() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        assertTrue(stack.isFull());
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
        assertEquals(4, stack.maxSize);
        assertFalse(stack.isFull());
    }
}
// ```