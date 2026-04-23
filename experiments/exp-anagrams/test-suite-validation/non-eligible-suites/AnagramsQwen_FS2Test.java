package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsQwen_FS2Test {

    @Test
    void testApproach2_AnagramStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_NonAnagramStrings() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    void testApproach2_DifferentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    void testApproach2_IdenticalStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("test", "test"));
    }

    @Test
    void testApproach2_EmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_SingleCharacterAnagram() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    void testApproach2_SingleCharacterNonAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", "b"));
    }

    @Test
    void testApproach2_CaseSensitiveAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("Listen", "silent"));
    }

    @Test
    void testApproach2_RepeatedCharactersAnagram() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("aabbcc", "abcabc"));
    }

    @Test
    void testApproach2_RepeatedCharactersNonAnagram() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("aabbc", "abcab"));
    }
}
// ```