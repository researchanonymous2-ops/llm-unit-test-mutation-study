package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayLlama_OS2Test {

    @Test
    void testPush_EmptyStack_ElementAdded() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        assertTrue(!stack.isEmpty());
    }

    @Test
    void testPush_NonEmptyStack_ElementAdded() {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
    }

    @Test
    void testPush_FullStack_StackResized() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
    }

    @Test
    void testPush_MultipleElements_StackSizeUpdated() {
        StackArray stack = new StackArray(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
    }

    @Test
    void testPush_MaxSizeReached_StackIsNotFullAfterResizing() {
        StackArray stack = new StackArray(1);
        stack.push(10);
        stack.push(20);
        assertTrue(!stack.isFull());
    }
}
// ```