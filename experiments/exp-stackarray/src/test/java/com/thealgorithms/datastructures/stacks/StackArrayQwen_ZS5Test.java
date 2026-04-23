package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_ZS5Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(3);
    }

    @Test
    public void testPush_IntoEmptyStack() {
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(42, stack.peek());
    }

    @Test
    public void testPush_IntoNonFullStack() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPush_WhenStackIsFullThenResizes() {
        stack.push(1);
        stack.push(2);
        stack.push(3); // Now it's full
        stack.push(4); // Should trigger resize and add the element
        assertFalse(stack.isFull());
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());
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