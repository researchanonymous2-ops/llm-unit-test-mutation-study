package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsQwen_POT3Test {

    @Test
    public void testSqueeze_nullOrEmptyString() {
        assertNull(CharSetUtils.squeeze(null, "a-z"));
        assertEquals("", CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    public void testSqueeze_nullOrEmptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
        assertEquals("hello", CharSetUtils.squeeze("hello", new String[]{}));
        assertEquals("hello", CharSetUtils.squeeze("hello"));
    }

    @Test
    public void testSqueeze_noRepetitionsInString() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-z"));
        assertEquals("abc", CharSetUtils.squeeze("abc", "a-c"));
    }

    @Test
    public void testSqueeze_withRepetitionsToSqueeze() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "a-z"));
        assertEquals("abcb", CharSetUtils.squeeze("aabbcb", "a-c"));
        assertEquals("abab", CharSetUtils.squeeze("aabbab", "a-b"));
    }
}
// ```