package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsQwen_FS5Test {

    @Test
    void testApproach2_withAnagramStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_withNonAnagramStrings() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    void testApproach2_withDifferentLengthStrings() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    void testApproach2_withEmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_withSameStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("test", "test"));
    }

    @Test
    void testApproach2_withAnagramCaseSensitive() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("evil", "vile"));
    }

    @Test
    void testApproach2_withNonAnagramSameLength() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abcd", "efgh"));
    }

    @Test
    void testApproach2_withRepeatedCharactersAnagram() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("aabbcc", "abcabc"));
    }

    @Test
    void testApproach2_withRepeatedCharactersNonAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("aabbcc", "aabbed"));
    }

    @Test
    void testApproach2_withSingleCharacterAnagram() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    void testApproach2_withSingleCharacterNonAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", "b"));
    }
}
// ```