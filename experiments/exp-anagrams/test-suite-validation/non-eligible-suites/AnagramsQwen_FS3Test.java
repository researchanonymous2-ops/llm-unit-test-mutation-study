package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;

public class AnagramsQwen_FS3Test {

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
    void testApproach2_SameStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("test", "test"));
    }

    @Test
    void testApproach2_EmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_OneEmptyString() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", ""));
    }

    @Test
    void testApproach2_CaseSensitive() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("Listen", "silent"));
    }

    @Test
    void testApproach2_RepeatedCharacters() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("aabbcc", "abcabc"));
    }

    @Test
    void testApproach2_NoCommonCharacters() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "def"));
    }

    @Test
    void testApproach2_LargeAnagram() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("conversation", "voices rant on"));
    }
}
// ```