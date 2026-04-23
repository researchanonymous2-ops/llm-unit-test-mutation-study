package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AnagramsGrok_ZS1Test {

    @Test
    void testApproach2_EmptyStrings() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    void testApproach2_OneEmptyOneNot() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("", "a"));
    }

    @Test
    void testApproach2_DifferentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", "ab"));
    }

    @Test
    void testApproach2_SameLengthNotAnagrams() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("aab", "abb"));
    }

    @Test
    void testApproach2_Anagrams() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_NotAnagrams() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    void testApproach2_UppercaseThrowsException() {
        Anagrams anagrams = new Anagrams();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> anagrams.approach2("Listen", "Silent"));
    }

    @Test
    void testApproach2_NonLetterThrowsException() {
        Anagrams anagrams = new Anagrams();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> anagrams.approach2("a1", "1a"));
    }
}
// ```