package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_ZS4Test {

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
    public void testSqueeze_withRange() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    public void testSqueeze_noMatch() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_multipleRanges() {
        assertEquals("helo world", org.apache.commons.lang3.CharSetUtils.squeeze("hello  world", "aeiou", " -~"));
    }

    @Test
    public void testSqueeze_allSameChar() {
        assertEquals("a", org.apache.commons.lang3.CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    public void testSqueeze_consecutiveChars() {
        assertEquals("abab", org.apache.commons.lang3.CharSetUtils.squeeze("aabbab", "ab"));
    }

    @Test
    public void testSqueeze_specialChars() {
        assertEquals("a*b*c", org.apache.commons.lang3.CharSetUtils.squeeze("a**b**c", "*"));
    }

    @Test
    public void testSqueeze_unicodeChars() {
        assertEquals("héllo", org.apache.commons.lang3.CharSetUtils.squeeze("hééllo", "é"));
    }

    @Test
    public void testSqueeze_emptyStringWithSet() {
        assertEquals("", org.apache.commons.lang3.CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    public void testSqueeze_singleCharString() {
        assertEquals("a", org.apache.commons.lang3.CharSetUtils.squeeze("a", "a"));
    }

    @Test
    public void testSqueeze_noRepeats() {
        assertEquals("abc", org.apache.commons.lang3.CharSetUtils.squeeze("abc", "a-z"));
    }
}
// ```