package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.thealgorithms.strings.StringCompression;

public class StringCompressionGrok_ZS3Test {

    @Test
    public void testCompress_EmptyString() {
        assertEquals("", StringCompression.compress(""));
    }

    @Test
    public void testCompress_SingleChar() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_NoRepeats() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_AllSame() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_SingleRepeat() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }

    @Test
    public void testCompress_MultipleGroups() {
        assertEquals("a2b3c2", StringCompression.compress("aabbbcc"));
    }

    @Test
    public void testCompress_LastCharUnique() {
        assertEquals("a3b", StringCompression.compress("aaab"));
    }

    @Test
    public void testCompress_FirstCharUnique() {
        assertEquals("ba3", StringCompression.compress("baaa"));
    }

    @Test
    public void testCompress_WithSpaces() {
        assertEquals("a2 2b", StringCompression.compress("aa  b"));
    }

    @Test
    public void testCompress_LongString() {
        assertEquals("a4b2c3d", StringCompression.compress("aaaabbcccd"));
    }
}
// ```