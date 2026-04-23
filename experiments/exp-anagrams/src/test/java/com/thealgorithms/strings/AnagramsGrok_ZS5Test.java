package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsGrok_ZS5Test {

    @Test
    public void testApproach2_anagramTrue() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("deal", "lead"));
    }

    @Test
    public void testApproach2_anagramFalseDifferentFrequencies() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("deal", "deaf"));
    }

    @Test
    public void testApproach2_differentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("deal", "deals"));
    }

    @Test
    public void testApproach2_emptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    public void testApproach2_oneEmptyOneNot() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("", "a"));
    }

    @Test
    public void testApproach2_sameLengthDifferentFrequencies() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("aa", "ab"));
    }

    @Test
    public void testApproach2_anagramWithRepetitions() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("aabb", "abab"));
    }

    @Test
    public void testApproach2_identicalStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("test", "test"));
    }

    @Test
    public void testApproach2_singleCharacterMatch() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_singleCharacterNoMatch() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", "b"));
    }
}
// ```