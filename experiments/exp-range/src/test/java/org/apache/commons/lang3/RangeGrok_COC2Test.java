package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeGrok_COC2Test {

    @Test
    void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(1, 5);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_ElementBefore() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(-1, range.elementCompareTo(0));
    }

    @Test
    void testElementCompareTo_ElementAfter() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(1, range.elementCompareTo(6));
    }

    @Test
    void testElementCompareTo_ElementInside() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(0, range.elementCompareTo(3));
    }
}
// ```