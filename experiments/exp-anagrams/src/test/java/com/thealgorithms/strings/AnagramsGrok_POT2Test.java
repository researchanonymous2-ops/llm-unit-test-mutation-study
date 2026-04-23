package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.strings.Anagrams;

public class AnagramsGrok_POT2Test {

    @Test
    public void testApproach2_DifferentLengths() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "ab"));
    }

    @Test
    public void testApproach2_SameFrequencies() {
        Anagrams anagrams = new Anagrams();
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_DifferentFrequencies() {
        Anagrams anagrams = new Anagrams();
        assertFalse(anagrams.approach2("abc", "abd"));
    }
}
// ```