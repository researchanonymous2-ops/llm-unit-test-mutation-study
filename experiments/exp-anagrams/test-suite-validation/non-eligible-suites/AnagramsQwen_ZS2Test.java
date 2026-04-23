package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_ZS2Test {

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
        assertTrue(anagrams.approach2("listen", "listen"));
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
    public void testApproach2_anagramsUppercase() {
        assertTrue(anagrams.approach2("CAT", "TAC"));
    }

    @Test
    public void testApproach2_notAnagramsUppercase() {
        assertFalse(anagrams.approach2("CAT", "TAG"));
    }

    @Test
    public void testApproach2_mixedCaseNotAnagrams() {
        assertFalse(anagrams.approach2("Listen", "Silent"));
    }

    @Test
    public void testApproach2_repeatedCharactersAnagram() {
        assertTrue(anagrams.approach2("aab", "aba"));
    }

    @Test
    public void testApproach2_repeatedCharactersNotAnagram() {
        assertFalse(anagrams.approach2("aab", "abb"));
    }

    @Test
    public void testApproach2_singleCharacterAnagram() {
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_singleCharacterNotAnagram() {
        assertFalse(anagrams.approach2("a", "b"));
    }
}
// ```