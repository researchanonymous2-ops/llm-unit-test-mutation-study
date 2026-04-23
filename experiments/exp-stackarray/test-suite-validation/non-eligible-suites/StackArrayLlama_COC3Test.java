package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayLlama_COC3Test {

    @Test
    public void testPush_NotFull() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPush_Full() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
        assertEquals(4, stack.maxSize); // Note: maxSize is private, you may need to add a getter for this
    }

    @Test
    public void testPush_MultipleTimes() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPush_AfterResize() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        stack.push(30); // triggers resize
        stack.push(40);
        assertEquals(4, stack.size());
        assertEquals(40, stack.peek());
    }
}
// ```