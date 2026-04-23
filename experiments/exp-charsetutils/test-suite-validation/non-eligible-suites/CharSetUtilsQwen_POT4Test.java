package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.apache.commons.lang3.CharSetUtils.squeeze;

public class CharSetUtilsQwen_POT4Test {

    @Test
    public void testSqueeze_nullString() {
        assertEquals(null, squeeze(null, "a-z"));
    }

    @Test
    public void testSqueeze_emptyString() {
        assertEquals("", squeeze("", "a-z"));
    }

    @Test
    public void testSqueeze_nullSet() {
        assertEquals("hello", squeeze("hello", (String[]) null));
    }

    @Test
    public void testSqueeze_emptySet() {
        assertEquals("hello", squeeze("hello"));
    }

    @Test
    public void testSqueeze_noRepetitions() {
        assertEquals("hello", squeeze("hello", "a-d"));
    }

    @Test
    public void testSqueeze_withRepetitions() {
        assertEquals("helo", squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_mixedRepetitions() {
        assertEquals("xyzyx", squeeze("xyzzzyxxx", "z"));
    }

    @Test
    public void testSqueeze_allRepetitions() {
        assertEquals("a", squeeze("aaaaaa", "a"));
    }

    @Test
    public void testSqueeze_startingRepetition() {
        assertEquals("abcbca", squeeze("aaabcbcaa", "a"));
    }

    @Test
    public void testSqueeze_complexPattern() {
        assertEquals("helo world", squeeze("heeeellllo worrrrld", "aeiou"));
    }
}
// ```