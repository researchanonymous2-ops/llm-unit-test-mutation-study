package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayLlama_FS3Test {

    @Test
    void testPush_OnEmptyStack_IncreasesSize() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        assertEquals(1, stack.size());
    }

    @Test
    void testPush_OnEmptyStack_MakesStackNotEmpty() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPush_MultipleElements_IncreasesSizeCorrectly() {
        StackArray stack = new StackArray(3);
        stack.push(4);
        stack.push(6);
        stack.push(8);
        assertEquals(3, stack.size());
    }

    @Test
    void testPush_OnFullStack_TriggersResize() {
        StackArray stack = new StackArray(1);
        stack.push(5);
        stack.push(9);
        assertEquals(2, stack.size());
    }

    @Test
    void testPush_AfterResize_CorrectlyStoresElements() {
        StackArray stack = new StackArray(1);
        stack.push(5);
        stack.push(9);
        assertEquals(9, stack.peek());
    }

    @Test
    void testPush_MultipleTimes_CheckTopElement() {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
    }
}
// ```