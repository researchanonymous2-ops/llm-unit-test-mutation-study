package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffGrok_ZS5Test {

    @Test
    public void testVerhoeffCheck_ValidInput() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
        assertTrue(Verhoeff.verhoeffCheck("123456789"));
        assertTrue(Verhoeff.verhoeffCheck("0"));
    }

    @Test
    public void testVerhoeffCheck_InvalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
        assertFalse(Verhoeff.verhoeffCheck("123456788"));
        assertFalse(Verhoeff.verhoeffCheck("1"));
    }

    @Test
    public void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    public void testVerhoeffCheck_NonDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("12 3"));
    }

    @Test
    public void testVerhoeffCheck_EmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
    }
}
// ```