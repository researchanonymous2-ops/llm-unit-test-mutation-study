package com.thealgorithms.datastructures.stacks;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.datastructures.stacks.StackArray;
import org.junit.jupiter.api.Test;

public class StackArrayLlama_FS5Test {

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
        assertEquals(1, stack.size());
        stack.push(9);
        assertEquals(2, stack.size());
    }

    @Test
    void testPush_AfterResize_MaintainsPreviousElements() {
        StackArray stack = new StackArray(1);
        stack.push(5);
        stack.push(9);
        assertEquals(9, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    void testPush_MultipleTimes_AfterMultipleResizes() {
        StackArray stack = new StackArray(1);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.size());
    }
}
// ```