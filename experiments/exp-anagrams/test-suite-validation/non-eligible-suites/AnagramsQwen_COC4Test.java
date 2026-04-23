package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AnagramsQwen_COC4Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_differentLengths() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_sameLengthsNotAnagrams() {
        assertFalse(anagrams.approach2("abc", "def"));
    }

    @Test
    public void testApproach2_sameStrings() {
        assertTrue(anagrams.approach2("abc", "abc"));
    }

    @Test
    public void testApproach2_anagrams() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_anagramsDifferentCase() {
        assertFalse(anagrams.approach2("Listen", "silent"));
    }

    @Test
    public void testApproach2_emptyStrings() {
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    public void testApproach2_singleCharacterMatch() {
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_singleCharacterNoMatch() {
        assertFalse(anagrams.approach2("a", "b"));
    }
}
// ```