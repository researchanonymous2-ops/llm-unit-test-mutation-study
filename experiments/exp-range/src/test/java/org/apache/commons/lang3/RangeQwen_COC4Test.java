package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class RangeQwen_COC4Test {

    private Range<Integer> range;

    @BeforeEach
    public void setUp() {
        range = Range.between(5, 10);
    }

    @Test
    public void testElementCompareTo_NullElement() {
        assertThrows(NullPointerException.class, () -> {
            range.elementCompareTo(null);
        });
    }

    @Test
    public void testElementCompareTo_ElementAfterRange() {
        int element = 3;
        int result = range.elementCompareTo(element);
        assertEquals(-1, result);
    }

    @Test
    public void testElementCompareTo_ElementBeforeRange() {
        int element = 15;
        int result = range.elementCompareTo(element);
        assertEquals(1, result);
    }

    @Test
    public void testElementCompareTo_ElementWithinRange() {
        int element = 7;
        int result = range.elementCompareTo(element);
        assertEquals(0, result);
    }

    @Test
    public void testElementCompareTo_ElementEqualToMinimum() {
        int element = 5;
        int result = range.elementCompareTo(element);
        assertEquals(0, result);
    }

    @Test
    public void testElementCompareTo_ElementEqualToMaximum() {
        int element = 10;
        int result = range.elementCompareTo(element);
        assertEquals(0, result);
    }
}
// ```