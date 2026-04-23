package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_ZS1Test {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_bothEmptyStrings() {
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    public void testApproach2_oneEmptyString() {
        assertFalse(anagrams.approach2("", "a"));
    }

    @Test
    public void testApproach2_differentLengths() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_sameStrings() {
        assertTrue(anagrams.approach2("abc", "abc"));
    }

    @Test
    public void testApproach2_anagramsLowercase() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_notAnagramsLowercase() {
        assertFalse(anagrams.approach2("hello", "bello"));
    }

    @Test
    public void testApproach2_anagramsMixedOrder() {
        assertTrue(anagrams.approach2("evil", "vile"));
    }

    @Test
    public void testApproach2_repeatedCharactersAnagrams() {
        assertTrue(anagrams.approach2("aabbcc", "abcabc"));
    }

    @Test
    public void testApproach2_repeatedCharactersNotAnagrams() {
        assertFalse(anagrams.approach2("aabbcc", "aabbcx"));
    }

    @Test
    public void testApproach2_singleCharacterAnagrams() {
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_singleCharacterNotAnagrams() {
        assertFalse(anagrams.approach2("a", "b"));
    }
}
// ```