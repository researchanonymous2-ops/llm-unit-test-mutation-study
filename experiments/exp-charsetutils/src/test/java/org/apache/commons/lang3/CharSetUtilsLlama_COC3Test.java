package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharSetUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CharSetUtilsLlama_COC3Test {

    @Test
    public void testSqueeze_NullString() {
        String result = CharSetUtils.squeeze(null, "a-e");
        assertNull(result);
    }

    @Test
    public void testSqueeze_EmptyString() {
        String result = CharSetUtils.squeeze("", "a-e");
        assertEquals("", result);
    }

    @Test
    public void testSqueeze_NullSet() {
        String result = CharSetUtils.squeeze("hello", (String[]) null);
        assertEquals("hello", result);
    }

    @Test
    public void testSqueeze_EmptySet() {
        String result = CharSetUtils.squeeze("hello", new String[]{});
        assertEquals("hello", result);
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        String result = CharSetUtils.squeeze("hello", "x-z");
        assertEquals("hello", result);
    }

    @Test
    public void testSqueeze_Squeeze() {
        String result = CharSetUtils.squeeze("hello", "l");
        assertEquals("helo", result);
    }

    @Test
    public void testSqueeze_MultipleSqueeze() {
        String result = CharSetUtils.squeeze("hellooo", "lo");
        assertEquals("helo", result);
    }
}
// ```