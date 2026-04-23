package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_ZS3Test {

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
    public void testSqueeze_emptyStringInSet() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_noRepetition() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_withRepetitionInRange() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_withRepetitionNotInRange() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "A-Z"));
    }

    @Test
    public void testSqueeze_multipleRanges() {
        assertEquals("helo world", org.apache.commons.lang3.CharSetUtils.squeeze("hello  world", "a-z", " "));
    }

    @Test
    public void testSqueeze_consecutiveRepetitions() {
        assertEquals("abcabc", org.apache.commons.lang3.CharSetUtils.squeeze("aabbccaaabbcc", "abc"));
    }

    @Test
    public void testSqueeze_specialCharacters() {
        assertEquals("a*b*c", org.apache.commons.lang3.CharSetUtils.squeeze("a**b**c", "*"));
    }

    @Test
    public void testSqueeze_unicodeCharacters() {
        assertEquals("héllo", org.apache.commons.lang3.CharSetUtils.squeeze("hééllo", "a-z"));
    }

    @Test
    public void testSqueeze_numerics() {
        assertEquals("123a123b123", org.apache.commons.lang3.CharSetUtils.squeeze("112233aa112233bb112233", "0-9", "a-b"));
    }
}
// ```