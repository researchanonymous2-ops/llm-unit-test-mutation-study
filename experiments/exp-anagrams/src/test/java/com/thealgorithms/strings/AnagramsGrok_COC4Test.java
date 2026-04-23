package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AnagramsGrok_COC4Test {

    private final Anagrams anagrams = new Anagrams();

    @Test
    void testApproach2_DifferentLengths() {
        assertFalse(anagrams.approach2("a", "ab"));
    }

    @Test
    void testApproach2_SameLengthsIdenticalFrequencies() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_SameLengthsDifferentFrequencies() {
        assertFalse(anagrams.approach2("listen", "silenx"));
    }
}
// ```