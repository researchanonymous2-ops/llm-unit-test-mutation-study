package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RangeLlama_ZS1Test {

    @Test
    public void testElementCompareTo_ElementIsNull() {
        Range<Integer> range = Range.between(1, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    public void testElementCompareTo_ElementIsBeforeRange() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(-1, range.elementCompareTo(0));
    }

    @Test
    public void testElementCompareTo_ElementIsWithinRange() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    public void testElementCompareTo_ElementIsAfterRange() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(1, range.elementCompareTo(11));
    }

    @Test
    public void testElementCompareTo_ElementIsMinimum() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(0, range.elementCompareTo(1));
    }

    @Test
    public void testElementCompareTo_ElementIsMaximum() {
        Range<Integer> range = Range.between(1, 10);
        assertEquals(0, range.elementCompareTo(10));
    }
}
// ```