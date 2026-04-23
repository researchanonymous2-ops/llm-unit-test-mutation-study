package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCompressionGrok_POT4Test {

    @Test
    public void testCompress_SingleChar() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_Repeated() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_Alternating() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_LastDifferent() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }
}
// ```