package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_COC5Test {

    @Test
    public void testCompress_singleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_allSameCharacters() {
        assertEquals("a4", StringCompression.compress("aaaa"));
    }

    @Test
    public void testCompress_noRepetition() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_mixedRepetition() {
        assertEquals("a3b1c2", StringCompression.compress("aaabcc"));
    }

    @Test
    public void testCompress_twoSameAtEnd() {
        assertEquals("a1b2", StringCompression.compress("abb"));
    }

    @Test
    public void testCompress_longRepetition() {
        assertEquals("x10", StringCompression.compress("xxxxxxxxxx"));
    }
}
// ```