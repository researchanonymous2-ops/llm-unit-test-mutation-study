package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.Range;

public class RangeGrok_POT5Test {

    @Test
    void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(5, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_Before() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    void testElementCompareTo_After() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(1, range.elementCompareTo(12));
    }

    @Test
    void testElementCompareTo_Inside() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
    }
}
// ```