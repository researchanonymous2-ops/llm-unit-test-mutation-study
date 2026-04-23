package com.thealgorithms.strings;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.thealgorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;

public class StringCompressionLlama_OS5Test {

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
    void testCompress_CompressedStringMultipleCharactersNoCountForSingle() {
        assertEquals("a3bc", StringCompression.compress("aaabc"));
    }

    @Test
    void testCompress_CompressedStringLastCharacterRepeated() {
        assertEquals("a3b2", StringCompression.compress("aaabb"));
    }

    @Test
    void testCompress_CompressedStringFirstCharacterRepeated() {
        assertEquals("a2b1c3", StringCompression.compress("aabcdddc"));
    }

    @Test
    void testCompress_EmptyString() {
        assertEquals("", StringCompression.compress(""));
    }
}
// ```