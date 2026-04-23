package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_COC5Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_DifferentLengths() {
        assertFalse(anagrams.approach2("abc", "abcd"));
    }

    @Test
    public void testApproach2_SameLengthNotAnagrams() {
        assertFalse(anagrams.approach2("abc", "def"));
    }

    @Test
    public void testApproach2_SameLengthAnagrams() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }
}
// ```