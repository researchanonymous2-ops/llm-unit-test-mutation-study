package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionLlama_OS1Test {

    @Test
    void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    void testCompress_NoCompression() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    void testCompress_CompressedString() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    void testCompress_CompressedStringMultipleCharacters() {
        assertEquals("a3b2c1", StringCompression.compress("aaabbc"));
    }

    @Test
    void testCompress_CompressedStringAtTheEnd() {
        assertEquals("a1b3", StringCompression.compress("abbb"));
    }

    @Test
    void testCompress_CompressedStringAtTheBeginning() {
        assertEquals("a3b1", StringCompression.compress("aaab"));
    }

    @Test
    void testCompress_LongSequence() {
        assertEquals("a10", StringCompression.compress("aaaaaaaaaa"));
    }

    @Test
    void testCompress_SameCharacters() {
        assertEquals("a5", StringCompression.compress("aaaaa"));
    }

    @Test
    void testCompress_DifferentCharacters() {
        assertEquals("a1b1c1d1e1", StringCompression.compress("abcde"));
    }
}
// ```