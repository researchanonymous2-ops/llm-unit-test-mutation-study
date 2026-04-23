package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_COC1Test {

    @Test
    public void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_NonDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
    }

    @Test
    public void testVerhoeffCheck_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    public void testVerhoeffCheck_ValidTrue() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_ValidFalse() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    public void testVerhoeffCheck_SingleDigitValid() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    public void testVerhoeffCheck_SingleDigitInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    public void testVerhoeffCheck_LongerValid() {
        assertTrue(Verhoeff.verhoeffCheck("1234567890"));
    }

    @Test
    public void testVerhoeffCheck_LongerInvalid() {
        assertFalse(Verhoeff.verhoeffCheck("1234567891"));
    }
}
// ```