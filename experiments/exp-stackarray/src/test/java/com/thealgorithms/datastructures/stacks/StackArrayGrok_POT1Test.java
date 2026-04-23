package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_POT1Test {

    @Test
    public void testPush_DirectInsert() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertEquals(10, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void testPush_AfterResize() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
    }
}
// ```