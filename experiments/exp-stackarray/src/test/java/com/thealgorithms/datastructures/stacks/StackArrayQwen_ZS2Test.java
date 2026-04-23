package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_ZS2Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(3);
    }

    @Test
    public void testPush_OnEmptyStack() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPush_WhenStackHasSpace() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPush_WhenStackIsFullAndNeedsResize() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        stack.push(4);
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_MultipleResizes() {
        StackArray smallStack = new StackArray(1);
        smallStack.push(100);
        smallStack.push(200);
        smallStack.push(300);
        assertEquals(3, smallStack.size());
        assertEquals(300, smallStack.peek());
    }
}
// ```