package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayLlama_ZS1Test {

    @Test
    public void testPush_Element() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPush_MultipleElements() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPush_FullStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    public void testPush_EmptyStack() {
        StackArray stack = new StackArray(5);
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPush_Resize() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        stack.push(30);
        assertEquals(10, stackArrayGet(stack, 0));
        assertEquals(20, stackArrayGet(stack, 1));
        assertEquals(30, stackArrayGet(stack, 2));
        assertEquals(3, stack.size());
    }

    private int stackArrayGet(StackArray stack, int index) {
        try {
            java.lang.reflect.Field field = StackArray.class.getDeclaredField("stackArray");
            field.setAccessible(true);
            int[] stackArray = (int[]) field.get(stack);
            return stackArray[index];
        } catch (Exception e) {
            fail("Failed to access stackArray field");
            return -1;
        }
    }
}
// ```