package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionQwen_POT3Test {

    @Test
    public void testCompress_T1() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_T2() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_T3() {
        assertEquals("a1b1c1", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_T4() {
        assertEquals("a2b1", StringCompression.compress("aab"));
    }
}
// ```