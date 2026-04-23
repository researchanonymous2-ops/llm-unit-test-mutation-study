package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AnagramsGrok_COC5Test {

    @Test
    void testApproach2_DifferentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("a", "ab"));
    }

    @Test
    void testApproach2_SameLengthsSameFrequencies() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_SameLengthsDifferentFrequencies() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("listen", "silenx"));
    }
}
// ```