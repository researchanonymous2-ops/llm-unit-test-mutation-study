package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_ZS5Test {

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
    public void testSqueeze_singleCharacterRepetition() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "l"));
    }

    @Test
    public void testSqueeze_multipleCharacterRepetition() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("helllo", "l"));
    }

    @Test
    public void testSqueeze_rangeSet() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    public void testSqueeze_noMatch() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_mixedRepetitions() {
        assertEquals("abcabc", org.apache.commons.lang3.CharSetUtils.squeeze("aabbccaaabbbccc", "a-c"));
    }

    @Test
    public void testSqueeze_allCharactersSame() {
        assertEquals("a", org.apache.commons.lang3.CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    public void testSqueeze_noRepetition() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_emptyStringWithSet() {
        assertEquals("", org.apache.commons.lang3.CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    public void testSqueeze_specialCharacters() {
        assertEquals("a*b*c", org.apache.commons.lang3.CharSetUtils.squeeze("a**b**c", "*"));
    }

    @Test
    public void testSqueeze_multipleSets() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "l", "o"));
    }

    @Test
    public void testSqueeze_consecutiveDifferentChars() {
        assertEquals("abab", org.apache.commons.lang3.CharSetUtils.squeeze("aabbab", "a", "b"));
    }
}
// ```