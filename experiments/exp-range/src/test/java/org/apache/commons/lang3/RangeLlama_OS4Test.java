package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeLlama_OS4Test {

    @Test
    void testElementCompareTo_ElementIsNull() {
        Range<Integer> range = Range.between(1, 5);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_ElementIsBeforeRange() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(-1, range.elementCompareTo(0));
    }

    @Test
    void testElementCompareTo_ElementIsWithinRange() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(0, range.elementCompareTo(3));
    }

    @Test
    void testElementCompareTo_ElementIsAfterRange() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(1, range.elementCompareTo(6));
    }

    @Test
    void testElementCompareTo_ElementIsMinimum() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(0, range.elementCompareTo(1));
    }

    @Test
    void testElementCompareTo_ElementIsMaximum() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(0, range.elementCompareTo(5));
    }
}
// ```