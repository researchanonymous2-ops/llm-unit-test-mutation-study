package com.thealgorithms.datastructures.stacks;

// ```java
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayQwen_ZS3Test {

    @Test
    public void testPush_IntoEmptyStack() {
        StackArray stack = new StackArray(3);
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(42, stack.peek());
    }

    @Test
    public void testPush_IntoNonFullStack() {
        StackArray stack = new StackArray(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
        assertFalse(stack.isEmpty());
        assertTrue(stack.isFull());
    }

    @Test
    public void testPush_WhenStackIsFullThenResizes() {
        StackArray stack = new StackArray(2);
        stack.push(100);
        stack.push(200);
        assertTrue(stack.isFull());
        stack.push(300);
        assertEquals(3, stack.size());
        assertEquals(300, stack.peek());
        assertFalse(stack.isFull());
    }

    @Test
    public void testPush_MultipleResizes() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        assertEquals(4, stack.size());
        assertEquals(40, stack.peek());
    }

    @Test
    public void testPush_PreservesExistingElementsAfterResize() {
        StackArray stack = new StackArray(2);
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.pop();
        stack.push(44);
        assertEquals(3, stack.size());
        assertEquals(44, stack.peek());
        stack.pop();
        assertEquals(22, stack.peek());
    }
}
// ```