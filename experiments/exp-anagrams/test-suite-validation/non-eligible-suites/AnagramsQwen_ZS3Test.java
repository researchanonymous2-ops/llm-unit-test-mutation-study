package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_ZS3Test {

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
    public void testApproach2_anagramsUppercase() {
        assertFalse(anagrams.approach2("LISTEN", "SILENT"));
    }

    @Test
    public void testApproach2_anagramsMixedCase() {
        assertFalse(anagrams.approach2("Listen", "Silent"));
    }

    @Test
    public void testApproach2_nonAnagrams() {
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    public void testApproach2_anagramsRepeatedCharacters() {
        assertTrue(anagrams.approach2("aabbcc", "abcabc"));
    }

    @Test
    public void testApproach2_nonAnagramsDifferentFrequencies() {
        assertFalse(anagrams.approach2("aab", "abb"));
    }

    @Test
    public void testApproach2_singleCharacterAnagrams() {
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_singleCharacterNonAnagrams() {
        assertFalse(anagrams.approach2("a", "b"));
    }

    @Test
    public void testApproach2_anagramsSpecialOrder() {
        assertTrue(anagrams.approach2("race", "care"));
    }

    @Test
    public void testApproach2_nonAnagramsSameLength() {
        assertFalse(anagrams.approach2("abcd", "abce"));
    }
}
// ```