package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.thealgorithms.strings.Anagrams;

public class AnagramsLlama_POT5Test {

    @Test
    public void testApproach2_DifferentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_Anagram() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_NotAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "world"));
    }
}
// ```