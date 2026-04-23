package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeGrok_COC1Test {

    @Test
    public void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(5, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    public void testElementCompareTo_ElementBeforeRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    public void testElementCompareTo_ElementAfterRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(1, range.elementCompareTo(15));
    }

    @Test
    public void testElementCompareTo_ElementInRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
    }
}
// ```