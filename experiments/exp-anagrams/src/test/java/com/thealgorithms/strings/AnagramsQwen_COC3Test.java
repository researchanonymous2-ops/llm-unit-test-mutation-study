package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_COC3Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_differentLengths() {
        assertFalse(anagrams.approach2("abc", "ab"));
    }

    @Test
    public void testApproach2_sameLengthsDifferentFrequencies() {
        assertFalse(anagrams.approach2("abc", "def"));
    }

    @Test
    public void testApproach2_sameLengthsSameFrequencies() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }
}
// ```