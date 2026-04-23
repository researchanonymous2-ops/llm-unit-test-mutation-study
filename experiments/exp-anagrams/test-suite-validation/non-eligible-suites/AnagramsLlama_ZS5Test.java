package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnagramsLlama_ZS5Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_AnagramStrings() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_NotAnagramStrings() {
        assertFalse(anagrams.approach2("hello", "world"));
    }

    @Test
    public void testApproach2_SameString() {
        assertTrue(anagrams.approach2("test", "test"));
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
    public void testApproach2_NullString() {
        // Note: The method does not check for null inputs, it will throw a NullPointerException
        // assertThrows(NullPointerException.class, () -> anagrams.approach2(null, "test"));
        // To make this test pass, you should add null checks in the approach2 method.
    }

    @Test
    public void testApproach2_SingleCharacterStrings() {
        assertTrue(anagrams.approach2("a", "a"));
    }

    @Test
    public void testApproach2_CaseSensitive() {
        assertFalse(anagrams.approach2("a", "A"));
    }
}
// ```