package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSetUtilsGrok_COC5Test {

    @Test
    public void testSqueeze_P0_strEmptyNull() {
        assertNull(CharSetUtils.squeeze(null, "a"));
    }

    @Test
    public void testSqueeze_P0_strEmptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a"));
    }

    @Test
    public void testSqueeze_P1_setDeepEmptyNull() {
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
    }

    @Test
    public void testSqueeze_P1_setDeepEmptyArray() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    public void testSqueeze_P2_loopEntersNoSkips() {
        assertEquals("abc", CharSetUtils.squeeze("abc", "a"));
    }

    @Test
    public void testSqueeze_P3_skipOccurs() {
        assertEquals("a", CharSetUtils.squeeze("aa", "a"));
    }

    @Test
    public void testSqueeze_P4_appendOccurs() {
        assertEquals("ab", CharSetUtils.squeeze("aab", "a"));
    }
}
// ```