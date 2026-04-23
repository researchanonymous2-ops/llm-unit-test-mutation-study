package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

public class RangeQwen_FS5Test {

    @Test
    void testElementCompareTo_elementBeforeRange_returnsNegativeOne() {
        Range<Integer> range = Range.between(5, 15);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    void testElementCompareTo_elementAfterRange_returnsPositiveOne() {
        Range<String> range = Range.between("b", "e");
        assertEquals(1, range.elementCompareTo("g"));
    }

    @Test
    void testElementCompareTo_elementInsideRange_returnsZero() {
        Range<Double> range = Range.between(1.5, 7.8);
        assertEquals(0, range.elementCompareTo(4.2));
    }

    @Test
    void testElementCompareTo_elementEqualToMinimum_returnsZero() {
        Range<Character> range = Range.between('a', 'z');
        assertEquals(0, range.elementCompareTo('a'));
    }

    @Test
    void testElementCompareTo_elementEqualToMaximum_returnsZero() {
        Range<Integer> range = Range.between(10, 20);
        assertEquals(0, range.elementCompareTo(20));
    }

    @Test
    void testElementCompareTo_nullElement_throwsNullPointerException() {
        Range<Integer> range = Range.between(1, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    void testElementCompareTo_elementJustBeforeRange_returnsNegativeOne() {
        Range<Integer> range = Range.between(10, 20);
        assertEquals(-1, range.elementCompareTo(9));
    }

    @Test
    void testElementCompareTo_elementJustAfterRange_returnsPositiveOne() {
        Range<Integer> range = Range.between(10, 20);
        assertEquals(1, range.elementCompareTo(21));
    }
}
// ```