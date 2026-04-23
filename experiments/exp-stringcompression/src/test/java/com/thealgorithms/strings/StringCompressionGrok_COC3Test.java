package com.thealgorithms.strings;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionGrok_COC3Test {

    @Test
    public void testCompress_SingleCharacter() {
        assertEquals("a", StringCompression.compress("a"));
    }

    @Test
    public void testCompress_TwoIdenticalCharacters() {
        assertEquals("a2", StringCompression.compress("aa"));
    }

    @Test
    public void testCompress_TwoDifferentCharacters() {
        assertEquals("ab", StringCompression.compress("ab"));
    }

    @Test
    public void testCompress_ThreeIdenticalCharacters() {
        assertEquals("a3", StringCompression.compress("aaa"));
    }

    @Test
    public void testCompress_TwoIdenticalThenDifferent() {
        assertEquals("a2b", StringCompression.compress("aab"));
    }

    @Test
    public void testCompress_DifferentThenTwoIdentical() {
        assertEquals("ab2", StringCompression.compress("abb"));
    }

    @Test
    public void testCompress_AllDifferent() {
        assertEquals("abc", StringCompression.compress("abc"));
    }

    @Test
    public void testCompress_MultipleGroups() {
        assertEquals("a2b2c", StringCompression.compress("aabbc"));
    }

    @Test
    public void testCompress_SingleGroupAtEnd() {
        assertEquals("ab2", StringCompression.compress("abb"));
    }

    @Test
    public void testCompress_GroupAtStartAndEnd() {
        assertEquals("a2bc", StringCompression.compress("aabc"));
    }
}
// ```