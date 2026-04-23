package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_COC4Test {

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
        assertEquals("hello", CharSetUtils.squeeze("hello", (String) null));
    }

    @Test
    public void testSqueeze_emptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_noRepetition() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_withRepetition() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_multipleRepetitions() {
        assertEquals("ababa", CharSetUtils.squeeze("aabbabbaaabbab", "b"));
    }

    @Test
    public void testSqueeze_firstCharRepetition() {
        assertEquals("abbb", CharSetUtils.squeeze("aaabbb", "a"));
    }

    @Test
    public void testSqueeze_mixedChars() {
        assertEquals("helo world", CharSetUtils.squeeze("hello  world", "l"));
    }

    @Test
    public void testSqueeze_allCharsSame() {
        assertEquals("a", CharSetUtils.squeeze("aaaa", "a"));
    }
}
// ```