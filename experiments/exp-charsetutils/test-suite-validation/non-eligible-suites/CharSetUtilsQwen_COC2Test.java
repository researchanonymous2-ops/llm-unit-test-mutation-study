package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_COC2Test {

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
    public void testSqueeze_noRepetition() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-d"));
    }

    @Test
    public void testSqueeze_withRepetitionNotInSet() {
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-d"));
    }

    @Test
    public void testSqueeze_withRepetitionInSet() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_multipleRepetitions() {
        assertEquals("aba", org.apache.commons.lang3.CharSetUtils.squeeze("aaabbaaabbbaaa", "ab"));
    }

    @Test
    public void testSqueeze_startingRepetition() {
        assertEquals("ab", org.apache.commons.lang3.CharSetUtils.squeeze("aaab", "a"));
    }

    @Test
    public void testSqueeze_endingRepetition() {
        assertEquals("ba", org.apache.commons.lang3.CharSetUtils.squeeze("baaa", "a"));
    }

    @Test
    public void testSqueeze_allSameCharacters() {
        assertEquals("a", org.apache.commons.lang3.CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    public void testSqueeze_complexSet() {
        assertEquals("helo wrd", org.apache.commons.lang3.CharSetUtils.squeeze("hello world", "aeiou"));
    }
}
// ```