package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_COC1Test {

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
        assertEquals("hello", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_withRepetitionNotInSet() {
        assertEquals("helloo", org.apache.commons.lang3.CharSetUtils.squeeze("helloo", "a-d"));
    }

    @Test
    public void testSqueeze_withRepetitionInSet() {
        assertEquals("helo", org.apache.commons.lang3.CharSetUtils.squeeze("hello", "l"));
    }

    @Test
    public void testSqueeze_multipleRepetitions() {
        assertEquals("helo world", org.apache.commons.lang3.CharSetUtils.squeeze("hello  world", "l "));
    }

    @Test
    public void testSqueeze_allSameCharacter() {
        assertEquals("a", org.apache.commons.lang3.CharSetUtils.squeeze("aaaa", "a"));
    }

    @Test
    public void testSqueeze_startingRepetition() {
        assertEquals("abcbba", org.apache.commons.lang3.CharSetUtils.squeeze("aabcbba", "a"));
    }
}
// ```