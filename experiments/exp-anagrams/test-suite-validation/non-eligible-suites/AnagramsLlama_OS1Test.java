package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsLlama_OS1Test {

    @Test
    void testApproach2_Anagram() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_NotAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    void testApproach2_SameString() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("abcde", "abcde"));
    }

    @Test
    void testApproach2_DifferentLength() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    void testApproach2_EmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_NullInput() {
        Anagrams anagrams = new Anagrams();
        try {
            anagrams.approach2(null, "abc");
            assert false;
        } catch (NullPointerException e) {
            // expected
        }
    }

    @Test
    void testApproach2_CaseSensitive() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("Listen", "silent"));
    }
}
// ```