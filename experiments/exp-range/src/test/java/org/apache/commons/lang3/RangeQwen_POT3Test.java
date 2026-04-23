package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

public class RangeQwen_POT3Test {

    private Range<Integer> range;
    
    @BeforeEach
    public void setUp() {
        range = Range.between(5, 10);
    }
    
    @Test
    public void testElementCompareTo_NullElement_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            range.elementCompareTo(null);
        });
    }
    
    @Test
    public void testElementCompareTo_ElementBeforeRange_ReturnsMinusOne() {
        int result = range.elementCompareTo(3);
        assertEquals(-1, result);
    }
    
    @Test
    public void testElementCompareTo_ElementAfterRange_ReturnsOne() {
        int result = range.elementCompareTo(15);
        assertEquals(1, result);
    }
    
    @Test
    public void testElementCompareTo_ElementWithinRange_ReturnsZero() {
        int result = range.elementCompareTo(7);
        assertEquals(0, result);
    }
    
    @Test
    public void testElementCompareTo_ElementEqualToMinimum_ReturnsZero() {
        int result = range.elementCompareTo(5);
        assertEquals(0, result);
    }
    
    @Test
    public void testElementCompareTo_ElementEqualToMaximum_ReturnsZero() {
        int result = range.elementCompareTo(10);
        assertEquals(0, result);
    }
}
// ```