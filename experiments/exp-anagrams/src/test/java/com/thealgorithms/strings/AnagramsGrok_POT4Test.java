package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsGrok_POT4Test {

    private final Anagrams anagrams = new Anagrams();

    @Test
    void testApproach2_DifferentLengths() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    void testApproach2_SameFrequencies() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_DifferentFrequencies() {
        assertFalse(anagrams.approach2("abc", "def"));
    }
}
// ```