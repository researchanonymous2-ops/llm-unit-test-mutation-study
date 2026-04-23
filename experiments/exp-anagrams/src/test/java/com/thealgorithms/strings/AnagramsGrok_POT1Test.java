package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsGrok_POT1Test {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_DifferentLengths() {
        assertFalse(anagrams.approach2("abc", "ab"));
    }

    @Test
    public void testApproach2_SameLengthsAndAnagrams() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_SameLengthsButNotAnagrams() {
        assertFalse(anagrams.approach2("abc", "def"));
    }
}
// ```