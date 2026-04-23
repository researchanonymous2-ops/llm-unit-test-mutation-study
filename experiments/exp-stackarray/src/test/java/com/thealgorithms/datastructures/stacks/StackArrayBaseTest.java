package com.thealgorithms.datastructures.stacks;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PITest.
 * Objetivo exclusivo: executar linhas relevantes do método push(int).
 */
public class StackArrayBaseTest {

    @Test
    void testPushOnEmptyStack() {
        StackArray stack = new StackArray(2);
        stack.push(10);

        assertTrue(!stack.isEmpty());
    }

    @Test
    void testPushTriggersResizeWhenFull() {
        StackArray stack = new StackArray(1);
        stack.push(5);   // ocupa a pilha
        stack.push(10);  // força resize interno

        assertTrue(!stack.isEmpty());
    }
}

