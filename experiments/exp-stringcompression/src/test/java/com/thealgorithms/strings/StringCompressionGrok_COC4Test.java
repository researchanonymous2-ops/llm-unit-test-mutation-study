package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCompressionGrok_COC4Test {

    @Test
    public void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_NoRepetitions() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_AllSame() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_RepetitionAtEnd() {
        assertEquals("a3b", StringCompression.compress("aaab"));
    }

    @Test
    public void testCompress_RepetitionInMiddle() {
        assertEquals("a2b2", StringCompression.compress("aabb"));
    }

    @Test
    public void testCompress_TwoSame() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    public void testCompress_TwoDifferent() {
        assertEquals("ab", StringCompression.compress("ab"));
    }
}
// ```