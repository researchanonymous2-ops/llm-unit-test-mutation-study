package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsLlama_FS5Test {

    @Test
    void testApproach2_WithAnagramStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_WithDifferentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "ab"));
    }

    @Test
    void testApproach2_WithSameLengthNonAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    void testApproach2_WithEmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_WithSingleCharacterStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    void testApproach2_WithNonAnagramSingleCharacterStrings() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", "b"));
    }

    @Test
    void testApproach2_WithUpperCaseLetters() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("A", "a"));
    }

    @Test
    void testApproach2_WithNonAlphabetCharacters() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a1", "1a"));
    }
}
// ```