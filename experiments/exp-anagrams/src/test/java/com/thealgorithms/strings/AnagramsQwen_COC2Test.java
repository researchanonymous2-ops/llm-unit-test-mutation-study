package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_COC2Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_differentLengths() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_sameLengthNotAnagrams() {
        assertFalse(anagrams.approach2("abc", "def"));
    }

    @Test
    public void testApproach2_sameLengthAnagrams() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }
}
// ```