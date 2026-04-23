package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AnagramsGrok_COC1Test {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_DifferentLengths() {
        assertEquals(false, anagrams.approach2("a", "ab"));
    }

    @Test
    public void testApproach2_SameLengthsSameFrequencies() {
        assertEquals(true, anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_SameLengthsDifferentFrequencies() {
        assertEquals(false, anagrams.approach2("listen", "silenx"));
    }
}
// ```