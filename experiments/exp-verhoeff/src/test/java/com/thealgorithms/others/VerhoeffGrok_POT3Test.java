package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VerhoeffGrok_POT3Test {

    @Test
    void testVerhoeffCheck_Valid() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    void testVerhoeffCheck_Invalid() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }
}
// ```