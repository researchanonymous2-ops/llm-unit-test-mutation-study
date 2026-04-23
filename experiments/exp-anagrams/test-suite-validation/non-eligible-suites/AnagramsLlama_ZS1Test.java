package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnagramsLlama_ZS1Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_Anagram() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_NotAnagram() {
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    public void testApproach2_DifferentCase() {
        assertFalse(anagrams.approach2("Listen", "silent"));
    }

    @Test
    public void testApproach2_SameString() {
        assertTrue(anagrams.approach2("abcde", "abcde"));
    }

    @Test
    public void testApproach2_DifferentLength() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_EmptyStrings() {
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    public void testApproach2_OneEmptyString() {
        assertFalse(anagrams.approach2("abc", ""));
    }

    @Test
    public void testApproach2_NonAlphabeticCharacters() {
        assertFalse(anagrams.approach2("abc!", "cba!"));
    }

    @Test
    public void testApproach2_NonLowerCaseCharacters() {
        assertFalse(anagrams.approach2("Abc", "cba"));
    }
}
// ```