package com.thealgorithms.others;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffGrok_COC3Test {

    @Test
    void testVerhoeffCheck_NullInput() {
        assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    void testVerhoeffCheck_InvalidCharacters() {
        assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
    }

    @Test
    void testVerhoeffCheck_ValidTrue() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheck_ValidFalse() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }
}
// ```