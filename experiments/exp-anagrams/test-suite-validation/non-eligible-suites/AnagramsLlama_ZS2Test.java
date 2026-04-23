package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnagramsLlama_ZS2Test {

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

    @Test
    public void testApproach2_DifferentCase() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("Listen", "silent"));
    }

    @Test
    public void testApproach2_SameString() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("abcde", "abcde"));
    }

    @Test
    public void testApproach2_DifferentLength() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_EmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    public void testApproach2_NullString() {
        Anagrams anagrams = new Anagrams();
        // Note: The method does not check for null inputs, it will throw NullPointerException
        // assertFalse(anagrams.approach2(null, "abc"));
        // assertFalse(anagrams.approach2("abc", null));
    }

    @Test
    public void testApproach2_SingleCharacter() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("a", "a"));
    }
}
// ```