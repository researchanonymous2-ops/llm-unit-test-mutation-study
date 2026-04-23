package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_ZS1Test {

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
    public void testPush_WhenNotFull() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPush_WhenFullTriggersResize() {
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

    @Test
    public void testPush_NegativeValue() {
        stack.push(-5);
        assertEquals(1, stack.size());
        assertEquals(-5, stack.peek());
    }

    @Test
    public void testPush_ZeroValue() {
        stack.push(0);
        assertEquals(1, stack.size());
        assertEquals(0, stack.peek());
    }

    @Test
    public void testPush_MaxIntValue() {
        stack.push(Integer.MAX_VALUE);
        assertEquals(1, stack.size());
        assertEquals(Integer.MAX_VALUE, stack.peek());
    }

    @Test
    public void testPush_MinIntValue() {
        stack.push(Integer.MIN_VALUE);
        assertEquals(1, stack.size());
        assertEquals(Integer.MIN_VALUE, stack.peek());
    }

    @Test
    public void testPush_AfterPopOperation() {
        stack.push(10);
        stack.push(20);
        stack.pop();
        stack.push(30);
        assertEquals(2, stack.size());
        assertEquals(30, stack.peek());
    }
}
// ```