package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionGrok_POT5Test {

    @Test
    public void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_RepeatedCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_AlternatingCharacters() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_LastCharacterOutsideRepetition() {
        assertEquals("a2b2c", StringCompression.compress("aabbc"));
    }
}
// ```