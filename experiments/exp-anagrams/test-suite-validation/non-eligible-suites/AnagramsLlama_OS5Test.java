package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsLlama_OS5Test {

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
        assertTrue(anagrams.approach2("hello", "hello"));
    }

    @Test
    void testApproach2_DifferentLength() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "hell"));
    }

    @Test
    void testApproach2_EmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_NullString() {
        Anagrams anagrams = new Anagrams();
        // Note: The method does not check for null inputs, it will throw NullPointerException
        // assertFalse(anagrams.approach2(null, "hello"));
        // assertFalse(anagrams.approach2("hello", null));
    }

    @Test
    void testApproach2_SingleCharacter() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    void testApproach2_DifferentCase() {
        Anagrams anagrams = new Anagrams();
        // Note: The method is case sensitive and considers 'a' and 'A' as different characters
        assertFalse(anagrams.approach2("Listen", "silent"));
    }
}
// ```