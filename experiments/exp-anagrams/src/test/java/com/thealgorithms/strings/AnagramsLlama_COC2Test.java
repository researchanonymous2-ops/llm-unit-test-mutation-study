package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.thealgorithms.strings.Anagrams;

public class AnagramsLlama_COC2Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_DifferentLengths() {
        String a = "abc";
        String b = "abcd";
        assertFalse(anagrams.approach2(a, b));
    }

    @Test
    public void testApproach2_SameLengthAndAnagram() {
        String a = "listen";
        String b = "silent";
        assertTrue(anagrams.approach2(a, b));
    }

    @Test
    public void testApproach2_SameLengthButNotAnagram() {
        String a = "hello";
        String b = "world";
        assertFalse(anagrams.approach2(a, b));
    }
}
// ```