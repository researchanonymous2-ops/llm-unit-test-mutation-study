package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffLlama_COC2Test {

    @Test
    public void testVerhoeffCheck_ValidInput() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_InvalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    public void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_NonDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
    }

    @Test
    public void testVerhoeffCheck_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }
}
// ```