package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_POT1Test {

    @Test
    public void testSqueeze_nullString() {
        assertNull(org.apache.commons.lang3.CharSetUtils.squeeze(null, "a-z"));
    }

    @Test
    public void testSqueeze_emptyString() {
        assertEquals("", org.apache.commons.lang3.CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    public void testSqueeze_nullSet() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    public void testSqueeze_emptySet() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello"));
    }

    @Test
    public void testSqueeze_noRepetitions() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_withRepetitions() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_multipleConsecutiveRepetitions() {
        assertEquals("abcabc", org.apache.commons.lang3.CharSetUtils.squeeze("aabbccccabcc", "c"));
    }

    @Test
    public void testSqueeze_firstCharacterInSet() {
        assertEquals("ab", org.apache.commons.lang3.CharSetUtils.squeeze("aaab", "a"));
    }

    @Test
    public void testSqueeze_complexPattern() {
        assertEquals("helo world", org.apache.commons.lang3.CharSetUtils.squeeze("hello  world", " "));
    }
}
// ```