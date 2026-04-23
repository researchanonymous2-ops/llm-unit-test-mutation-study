package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_COC5Test {

    @Test
    public void testSqueeze_nullString() {
        assertNull(CharSetUtils.squeeze(null, "a-z"));
    }

    @Test
    public void testSqueeze_emptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    public void testSqueeze_nullSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    public void testSqueeze_emptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_noRepetition() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-d"));
    }

    @Test
    public void testSqueeze_withRepetition() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_multipleRepetitions() {
        assertEquals("abcabc", CharSetUtils.squeeze("aabbccaaabbbccc", "abc"));
    }

    @Test
    public void testSqueeze_startingRepetition() {
        assertEquals("ab", CharSetUtils.squeeze("aaab", "a"));
    }

    @Test
    public void testSqueeze_endingRepetition() {
        assertEquals("ba", CharSetUtils.squeeze("baaa", "a"));
    }

    @Test
    public void testSqueeze_allSameCharacter() {
        assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    public void testSqueeze_noMatchInSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "x-z"));
    }

    @Test
    public void testSqueeze_complexSet() {
        assertEquals("helo world", CharSetUtils.squeeze("hello  world", " -~"));
    }
}
// ```