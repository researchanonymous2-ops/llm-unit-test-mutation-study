package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.Range;
import java.util.Comparator;

public class RangeGrok_ZS1Test {

    @Test
    public void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(1, 5);
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
    public void testElementCompareTo_ElementAtMinimum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    public void testElementCompareTo_ElementAtMaximum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(10));
    }

    @Test
    public void testElementCompareTo_ElementInsideRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
    }

    @Test
    public void testElementCompareTo_SingleElementRange() {
        Range<Integer> range = Range.is(5);
        assertEquals(0, range.elementCompareTo(5));
        assertEquals(-1, range.elementCompareTo(4));
        assertEquals(1, range.elementCompareTo(6));
    }

    @Test
    public void testElementCompareTo_WithCustomComparator() {
        Comparator<Integer> reverseComp = Comparator.reverseOrder();
        Range<Integer> range = Range.between(10, 5, reverseComp);
        assertEquals(-1, range.elementCompareTo(12));
        assertEquals(1, range.elementCompareTo(3));
        assertEquals(0, range.elementCompareTo(7));
    }
}
// ```