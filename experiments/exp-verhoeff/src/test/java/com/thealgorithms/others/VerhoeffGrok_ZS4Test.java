package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffGrok_ZS4Test {

    @Test
    void testVerhoeffCheck_ValidInput() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheck_SingleDigitValid() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    void testVerhoeffCheck_SingleDigitInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    void testVerhoeffCheck_LongerValid() {
        assertTrue(Verhoeff.verhoeffCheck("1234567890"));
    }

    @Test
    void testVerhoeffCheck_LongerInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1234567891"));
    }

    @Test
    void testVerhoeffCheck_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    void testVerhoeffCheck_NonDigitCharacters() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
    }

    @Test
    void testVerhoeffCheck_MixedCharacters() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
    }

    @Test
    void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }
}
// ```