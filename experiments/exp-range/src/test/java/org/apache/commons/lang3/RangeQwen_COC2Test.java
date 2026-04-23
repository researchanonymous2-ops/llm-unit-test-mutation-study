package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.Range;

public class RangeQwen_COC2Test {

    @Test
    public void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(1, 5);
        assertThrows(NullPointerException.class, () -> {
            range.elementCompareTo(null);
        });
    }

    @Test
    public void testElementCompareTo_ElementBeforeRange() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(-1, range.elementCompareTo(1));
    }

    @Test
    public void testElementCompareTo_ElementAfterRange() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(1, range.elementCompareTo(7));
    }

    @Test
    public void testElementCompareTo_ElementWithinRange() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(0, range.elementCompareTo(4));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMinimum() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(0, range.elementCompareTo(2));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMaximum() {
        Range<Integer> range = Range.between(2, 6);
        assertEquals(0, range.elementCompareTo(6));
    }
}
// ```