package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PITest.
 * Objetivo exclusivo: executar linhas relevantes do método compress(String).
 */
public class StringCompressionBaseTest {

    @Test
    void testCompressWithSingleCharacter() {
        // ativa o caso base: input.length() == 1
        String result = StringCompression.compress("A");
        assertEquals("A", result);
    }

    @Test
    void testCompressWithRepeatedCharacters() {
        // ativa o caminho com repetição de caracteres
        String result = StringCompression.compress("AA");
        assertEquals("A2", result);
    }

    @Test
    void testCompressWithNonRepeatedCharacters() {
        // ativa o caminho sem repetição
        String result = StringCompression.compress("AB");
        assertEquals("AB", result);
    }
}

