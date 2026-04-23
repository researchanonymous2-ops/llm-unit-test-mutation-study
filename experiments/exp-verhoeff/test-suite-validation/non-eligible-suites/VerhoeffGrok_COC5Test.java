package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffGrok_COC5Test {

    @Test
    void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    void testVerhoeffCheck_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }

    @Test
    void testVerhoeffCheck_ValidTrue_Short() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheck_ValidFalse_Short() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }

    @Test
    void testVerhoeffCheck_ValidTrue_Long() {
        assertTrue(Verhoeff.verhoeffCheck("123456789012"));
    }

    @Test
    void testVerhoeffCheck_ValidFalse_Long() {
        assertFalse(Verhoeff.verhoeffCheck("123456789013"));
    }

    @Test
    void testVerhoeffCheck_ValidTrue_SingleDigit() {
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    void testVerhoeffCheck_ValidFalse_SingleDigit() {
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    void testVerhoeffCheck_ValidTrue_LengthEight() {
        assertTrue(Verhoeff.verhoeffCheck("84736405"));
    }

    @Test
    void testVerhoeffCheck_ValidFalse_LengthEight() {
        assertFalse(Verhoeff.verhoeffCheck("84736406"));
    }

    @Test
    void testVerhoeffCheck_ValidTrue_LengthNine() {
        assertTrue(Verhoeff.verhoeffCheck("123456789"));
    }

    @Test
    void testVerhoeffCheck_ValidFalse_LengthNine() {
        assertFalse(Verhoeff.verhoeffCheck("123456788"));
    }
}
// ```