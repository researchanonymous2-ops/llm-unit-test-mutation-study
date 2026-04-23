package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.apache.commons.lang3.CharSetUtils.squeeze;

public class CharSetUtilsQwen_POT2Test {

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
    public void testSqueeze_noRepetition() {
        assertEquals("hello", squeeze("hello", "a-d"));
    }

    @Test
    public void testSqueeze_withRepetition() {
        assertEquals("helo", squeeze("hello", "a-z"));
    }

    @Test
    public void testSqueeze_multipleRepetitions() {
        assertEquals("abcabc", squeeze("aabbccaaabbbccc", "a-c"));
    }

    @Test
    public void testSqueeze_nonConsecutiveRepetitions() {
        assertEquals("abba", squeeze("aaaabbbbbaaaaa", "ab"));
    }
}
// ```