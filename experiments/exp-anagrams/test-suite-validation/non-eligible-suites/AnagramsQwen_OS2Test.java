package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsQwen_OS2Test {

    @Test
    void testApproach2_trueAnagrams() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_falseAnagrams() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    void testApproach2_differentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    void testApproach2_emptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_sameStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("test", "test"));
    }

    @Test
    void testApproach2_caseSensitive() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("Listen", "silent"));
    }

    @Test
    void testApproach2_repeatedCharacters() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("aabbcc", "abcabc"));
    }

    @Test
    void testApproach2_singleCharacter() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    void testApproach2_singleCharacterNotAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", "b"));
    }

    @Test
    void testApproach2_unicodeCharacters() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("café", "face"));
    }
}
// ```