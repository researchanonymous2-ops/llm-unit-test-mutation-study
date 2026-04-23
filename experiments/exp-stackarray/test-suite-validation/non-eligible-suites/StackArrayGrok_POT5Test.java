package com.thealgorithms.datastructures.stacks;

// ```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackArrayGrok_POT5Test {

    @Test
    void testPush_WhenNotFull() {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        Assertions.assertEquals(2, stack.size());
        Assertions.assertEquals(20, stack.peek());
    }

    @Test
    void testPush_WhenFull() {
        StackArray stack = new StackArray(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.size());
        Assertions.assertEquals(3, stack.peek());
        Assertions.assertTrue(stack.size() <= stack.maxSize);
    }
}
// ```