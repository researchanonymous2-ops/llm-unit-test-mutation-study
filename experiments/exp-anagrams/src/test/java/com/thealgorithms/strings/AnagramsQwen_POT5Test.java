package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramsQwen_POT5Test {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testApproach2_differentLengthStrings() {
        assertFalse(anagrams.approach2("abc", "ab"));
    }

    @Test
    public void testApproach2_anagramStrings() {
        assertTrue(anagrams.approach2("listen", "silent"));
    }

    @Test
    public void testApproach2_nonAnagramStrings() {
        assertFalse(anagrams.approach2("hello", "world"));
    }
}
// ```
