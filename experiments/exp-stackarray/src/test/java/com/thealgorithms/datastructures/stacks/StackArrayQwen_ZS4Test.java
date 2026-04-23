package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_ZS4Test {

    private StackArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackArray(3);
    }

    @Test
    public void testPush_ToEmptyStack() {
        stack.push(5);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(5, stack.peek());
    }

    @Test
    public void testPush_ToNonEmptyStack() {
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
        
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPush_WhenStackIsFull() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        
        stack.push(4);
        assertFalse(stack.isFull());
        assertEquals(4, stack.size());
        assertEquals(4, stack.peek());
    }

    @Test
    public void testPush_MultipleElements() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i * 10);
        }
        assertEquals(5, stack.size());
        assertEquals(50, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPush_SameValueMultipleTimes() {
        int value = 42;
        for (int i = 0; i < 4; i++) {
            stack.push(value);
        }
        assertEquals(4, stack.size());
        assertEquals(value, stack.peek());
        for (int i = 0; i < 4; i++) {
            assertEquals(value, stack.pop());
        }
    }

    @Test
    public void testPush_NegativeValues() {
        stack.push(-5);
        stack.push(-10);
        assertEquals(2, stack.size());
        assertEquals(-10, stack.peek());
    }

    @Test
    public void testPush_ZeroValue() {
        stack.push(0);
        assertEquals(1, stack.size());
        assertEquals(0, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPush_CausesResize() {
        StackArray smallStack = new StackArray(2);
        smallStack.push(1);
        smallStack.push(2);
        assertTrue(smallStack.isFull());
        
        smallStack.push(3);
        assertFalse(smallStack.isFull());
        assertEquals(3, smallStack.size());
        assertEquals(3, smallStack.peek());
    }

    @Test
    public void testPush_AfterPopOperation() {
        stack.push(100);
        stack.push(200);
        stack.push(300);
        
        int popped = stack.pop();
        assertEquals(300, popped);
        
        stack.push(400);
        assertEquals(3, stack.size());
        assertEquals(400, stack.peek());
    }
}
// ```