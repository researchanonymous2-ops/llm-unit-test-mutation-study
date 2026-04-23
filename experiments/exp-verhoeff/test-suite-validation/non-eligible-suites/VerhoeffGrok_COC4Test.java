package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffGrok_COC4Test {

    @Test
    void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    void testVerhoeffCheck_InvalidCharacters() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
    }

    @Test
    void testVerhoeffCheck_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    void testVerhoeffCheck_SingleDigitZero() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    void testVerhoeffCheck_SingleDigitOne() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    void testVerhoeffCheck_TwoDigitsValid() {
        assertTrue(Verhoeff.verhoeffCheck("14"));
    }

    @Test
    void testVerhoeffCheck_TwoDigitsInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("15"));
    }

    @Test
    void testVerhoeffCheck_FourDigitsValid() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheck_FourDigitsInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheck_LongerValid() {
        assertTrue(Verhoeff.verhoeffCheck("1234567890"));
    }

    @Test
    void testVerhoeffCheck_LongerInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1234567891"));
    }
}
// ```