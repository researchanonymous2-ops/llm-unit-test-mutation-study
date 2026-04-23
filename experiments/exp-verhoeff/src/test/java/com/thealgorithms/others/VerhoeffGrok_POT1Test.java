package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VerhoeffGrok_POT1Test {

    @Test
    public void testVerhoeffCheck_Valid() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_Invalid() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }
}
// ```