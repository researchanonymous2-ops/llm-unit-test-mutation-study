package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_ZS2Test {

    @Test
    public void testCompress_EmptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    public void testCompress_SingleChar() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_TwoSame() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    public void testCompress_TwoDifferent() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    public void testCompress_AllSame() {
        assertEquals("a4", StringCompression.compress("aaaa"));
    }

    @Test
    public void testCompress_NoRepeats() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_WithRepeats() {
        assertEquals("a2b2c", StringCompression.compress("aabbc"));
    }

    @Test
    public void testCompress_EndWithSingle() {
        assertEquals("a3b", StringCompression.compress("aaab"));
    }

    @Test
    public void testCompress_EndWithRepeat() {
        assertEquals("a2b3", StringCompression.compress("aabbb"));
    }

    @Test
    public void testCompress_Mixed() {
        assertEquals("a2b3c2", StringCompression.compress("aabbbcc"));
    }
}
// ```