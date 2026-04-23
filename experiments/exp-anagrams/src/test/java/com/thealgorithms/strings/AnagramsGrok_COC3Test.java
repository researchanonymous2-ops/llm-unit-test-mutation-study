package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.strings.Anagrams;

public class AnagramsGrok_COC3Test {

    @Test
    public void testApproach2_DifferentLengths() {
        Anagrams nm = new Anagrams();
        assertFalse(nm.approach2("a", "ab"));
    }

    @Test
    public void testApproach2_SameLengthsSameFrequencies() {
        Anagrams nm = new Anagrams();
        assertTrue(nm.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_SameLengthsDifferentFrequencies() {
        Anagrams nm = new Anagrams();
        assertFalse(nm.approach2("hello", "world"));
    }
}
// ```