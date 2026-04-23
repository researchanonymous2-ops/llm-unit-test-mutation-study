package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class CharSetUtilsGrok_POT1Test {

    @Test
    public void testSqueeze_NullOrEmptyStr() {
        // T0: retorno imediato quando str é nula ou vazia
        assertNull(CharSetUtils.squeeze(null, "a"));
        assertEquals("", CharSetUtils.squeeze("", "a"));
    }

    @Test
    public void testSqueeze_NullOrEmptySet() {
        // T1: retorno imediato quando set é nulo ou vazio
        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
        assertEquals("hello", CharSetUtils.squeeze("hello", "", ""));
    }

    @Test
    public void testSqueeze_NoSqueeze() {
        // T2: iteração do laço sem acionamento do continue
        assertEquals("abc", CharSetUtils.squeeze("abc", "a"));
        assertEquals("aabb", CharSetUtils.squeeze("aabb", "c"));
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    public void testSqueeze_WithSqueeze() {
        // T3: iteração do laço com acionamento do continue (remoção de repetição)
        assertEquals("helo", CharSetUtils.squeeze("hello", "l"));
        assertEquals("abbb", CharSetUtils.squeeze("aaabbb", "a"));
        assertEquals("ab", CharSetUtils.squeeze("aaabbb", "a", "b"));
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }
}
// ```