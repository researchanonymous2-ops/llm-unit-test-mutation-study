package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_POT2Test {

    @Test
    public void testSqueeze_NullOrEmptyStr() {
        assertEquals(null, CharSetUtils.squeeze(null, "a"));
        assertEquals("", CharSetUtils.squeeze("", "a"));
    }

    @Test
    public void testSqueeze_NullOrEmptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
        assertEquals("hello", CharSetUtils.squeeze("hello"));
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "d"));
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_WithSqueeze() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
        assertEquals("aab", CharSetUtils.squeeze("aaab", "a"));
    }
}
// ```