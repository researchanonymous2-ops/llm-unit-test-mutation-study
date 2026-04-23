package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffQwen_ZS1Test {

    @Test
    public void testVerhoeffCheck_validInput() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_invalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    public void testVerhoeffCheck_singleDigitValid() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    public void testVerhoeffCheck_singleDigitInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    public void testVerhoeffCheck_emptyString() {
        assertFalse(Verhoeff.verhoeffCheck(""));
    }

    @Test
    public void testVerhoeffCheck_longValidNumber() {
        assertTrue(Verhoeff.verhoeffCheck("12345678901234"));
    }

    @Test
    public void testVerhoeffCheck_longInvalidNumber() {
        assertFalse(Verhoeff.verhoeffCheck("12345678901235"));
    }

    @Test
    public void testVerhoeffCheck_nullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_nonDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("12a3"));
    }

    @Test
    public void testVerhoeffCheck_mixedNonDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("12-3"));
    }

    @Test
    public void testVerhoeffCheck_allZeros() {
        assertTrue(Verhoeff.verhoeffCheck("0000"));
    }
}
// ```