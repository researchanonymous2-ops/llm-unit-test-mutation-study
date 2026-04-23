package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_FS1Test {

    @Test
    void testVerhoeffCheck_ValidInput() {
        assertTrue(Verhoeff.verhoeffCheck("1237"));
    }

    @Test
    void testVerhoeffCheck_InvalidInput() {
        assertFalse(Verhoeff.verhoeffCheck("1238"));
    }

    @Test
    void testVerhoeffCheck_NonDigitThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck("12A3"));
    }

    @Test
    void testVerhoeffCheck_NullThrows() {
        assertThrows(NullPointerException.class,
            () -> Verhoeff.verhoeffCheck(null));
    }

    @Test
    void testVerhoeffCheck_EmptyStringThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> Verhoeff.verhoeffCheck(""));
    }
}
// ```