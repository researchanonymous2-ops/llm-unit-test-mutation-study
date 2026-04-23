package com.thealgorithms.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes no método approach2(String a, String b)
 * da classe Anagrams. Esta suíte tem como único objetivo permitir que o PITest
 * gere e execute mutantes no método alvo.
 */
public class AnagramsBaseTest {

    @Test
    void testApproach2_DifferentLengthStrings() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "ab"));
    }

    @Test
    void testApproach2_ValidAnagramStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("deal", "lead"));
    }

    @Test
    void testApproach2_NonAnagramStringsSameLength() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("deal", "deaf"));
    }
}

