package com.thealgorithms.strings;

// ```java
import com.thealgorithms.strings.Anagrams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnagramsLlama_POT2Test {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_DifferentLengths() {
        String a = "abc";
        String b = "abcd";
        assertFalse(anagrams.approach2(a, b));
    }

    @Test
    public void testApproach2_SameString() {
        String a = "listen";
        String b = "silent";
        assertTrue(anagrams.approach2(a, b));
    }

    @Test
    public void testApproach2_NotAnagram() {
        String a = "hello";
        String b = "world";
        assertFalse(anagrams.approach2(a, b));
    }
}
// ```