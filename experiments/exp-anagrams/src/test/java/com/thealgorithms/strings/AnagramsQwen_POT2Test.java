package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_POT2Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_differentLengths() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_sameFrequencies() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_differentFrequencies() {
        assertFalse(anagrams.approach2("hello", "bello"));
    }
}
// ```