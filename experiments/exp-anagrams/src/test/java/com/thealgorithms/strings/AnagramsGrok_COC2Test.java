package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramsGrok_COC2Test {

    @Test
    void testApproach2_DifferentLengths() {
        Anagrams nm = new Anagrams();
        assertFalse(nm.approach2("a", "ab"));
    }

    @Test
    void testApproach2_SameFrequencies() {
        Anagrams nm = new Anagrams();
        assertTrue(nm.approach2("listen", "silent"));
    }

    @Test
    void testApproach2_DifferentFrequencies() {
        Anagrams nm = new Anagrams();
        assertFalse(nm.approach2("hello", "world"));
    }
}
// ```