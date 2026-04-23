package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangeQwen_COC1Test {

    @Test
    public void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(1, 5);
        assertThrows(NullPointerException.class, () -> {
            range.elementCompareTo(null);
        });
    }

    @Test
    public void testElementCompareTo_ElementAfterRange() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(-1, range.elementCompareTo(0));
    }

    @Test
    public void testElementCompareTo_ElementBeforeRange() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(1, range.elementCompareTo(6));
    }

    @Test
    public void testElementCompareTo_ElementWithinRange() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(0, range.elementCompareTo(3));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMinimum() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(0, range.elementCompareTo(1));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMaximum() {
        Range<Integer> range = Range.between(1, 5);
        assertEquals(0, range.elementCompareTo(5));
    }
}
// ```