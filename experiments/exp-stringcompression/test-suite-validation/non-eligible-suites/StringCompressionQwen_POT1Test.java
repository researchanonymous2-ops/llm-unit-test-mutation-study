package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_POT1Test {

    @Test
    public void testCompress_singleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_repeatedCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_alternatingCharacters() {
        assertEquals("a1b1c1", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_mixedRepetitionAndAlternation() {
        assertEquals("a2b1c3d1", StringCompression.compress("aabcccd"));
    }
}
// ```