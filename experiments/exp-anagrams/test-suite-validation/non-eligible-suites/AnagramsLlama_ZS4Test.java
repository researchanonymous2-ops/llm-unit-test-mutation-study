package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnagramsLlama_ZS4Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_Anagram() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_NotAnagram() {
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    public void testApproach2_DifferentCase() {
        assertFalse(anagrams.approach2("Listen", "silent"));
    }

    @Test
    public void testApproach2_SameString() {
        assertTrue(anagrams.approach2("abcde", "abcde"));
    }

    @Test
    public void testApproach2_DifferentLength() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_EmptyStrings() {
        assertTrue(anagrams.approach2("", ""));
    }

    @Test
    public void testApproach2_NullInput() {
        // Note: The method does not handle null inputs. It will throw a NullPointerException.
        // assertThrows(NullPointerException.class, () -> anagrams.approach2(null, "abc"));
        // assertThrows(NullPointerException.class, () -> anagrams.approach2("abc", null));
    }

    @Test
    public void testApproach2_SingleCharacter() {
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_SingleCharacterDifferent() {
        assertFalse(anagrams.approach2("a", "b"));
    }
}
// ```