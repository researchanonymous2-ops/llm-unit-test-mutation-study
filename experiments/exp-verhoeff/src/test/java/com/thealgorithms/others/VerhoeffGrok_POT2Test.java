package com.thealgorithms.others;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VerhoeffGrok_POT2Test {

    @Test
    public void testVerhoeffCheck_True() {
        assertTrue(Verhoeff.verhoeffCheck("2363"));
    }

    @Test
    public void testVerhoeffCheck_False() {
        assertFalse(Verhoeff.verhoeffCheck("2364"));
    }
}
// ```