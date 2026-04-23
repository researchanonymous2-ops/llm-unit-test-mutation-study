package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_POT1Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_differentLengthStrings() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_sameStrings() {
        assertTrue(anagrams.approach2("abc", "abc"));
    }

    @Test
    public void testApproach2_anagramStrings() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_nonAnagramStrings() {
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    public void testApproach2_emptyStrings() {
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    public void testApproach2_singleCharacterSame() {
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_singleCharacterDifferent() {
        assertFalse(anagrams.approach2("a", "b"));
    }

    @Test
    public void testApproach2_caseSensitiveNotAnagram() {
        assertFalse(anagrams.approach2("Abc", "abc"));
    }

    @Test
    public void testApproach2_repeatedCharactersAnagram() {
        assertTrue(anagrams.approach2("aab", "aba"));
    }

    @Test
    public void testApproach2_repeatedCharactersNonAnagram() {
        assertFalse(anagrams.approach2("aab", "abb"));
    }
}
// ```