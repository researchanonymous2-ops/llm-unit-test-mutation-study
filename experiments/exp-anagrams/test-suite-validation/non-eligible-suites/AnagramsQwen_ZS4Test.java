package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_ZS4Test {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_bothStringsNull() {
        assertFalse(anagrams.approach2(null, null));
    }

    @Test
    public void testApproach2_firstStringNull() {
        assertFalse(anagrams.approach2(null, "abc"));
    }

    @Test
    public void testApproach2_secondStringNull() {
        assertFalse(anagrams.approach2("abc", null));
    }

    @Test
    public void testApproach2_differentLengths() {
        assertFalse(anagrams.approach2("ab", "abc"));
    }

    @Test
    public void testApproach2_emptyStrings() {
        assertTrue(anagrams.approach2("", ""));
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
    public void testApproach2_anagramsUppercase() {
        assertFalse(anagrams.approach2("LISTEN", "SILENT"));
    }

    @Test
    public void testApproach2_notAnagramsUppercase() {
        assertFalse(anagrams.approach2("HELLO", "BELLO"));
    }

    @Test
    public void testApproach2_anagramsWithRepeatedCharacters() {
        assertTrue(anagrams.approach2("aabbcc", "abcabc"));
    }

    @Test
    public void testApproach2_notAnagramsWithRepeatedCharacters() {
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

    @Test
    public void testApproach2_anagramsSameFrequencyDifferentOrder() {
        assertTrue(anagrams.approach2("abbc", "cbab"));
    }
}
// ```