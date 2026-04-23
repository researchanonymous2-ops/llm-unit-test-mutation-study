package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_COC3Test {

    @Test
    public void testSqueeze_NullStr() {
        assertNull(CharSetUtils.squeeze(null, "a"));
    }

    @Test
    public void testSqueeze_EmptyStr() {
        assertEquals("", CharSetUtils.squeeze("", "a"));
    }

    @Test
    public void testSqueeze_NullSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    public void testSqueeze_EmptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "x"));
    }

    @Test
    public void testSqueeze_SqueezeRepeated() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
    }

    @Test
    public void testSqueeze_SqueezeMultiple() {
        assertEquals("a", CharSetUtils.squeeze("aaa", "a"));
    }
}
// ```