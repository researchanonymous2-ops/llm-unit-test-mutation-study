package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangeQwen_ZS5Test {

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
    public void testElementCompareTo_ElementWithinRange() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(7));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMinimum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(5));
    }

    @Test
    public void testElementCompareTo_ElementEqualToMaximum() {
        Range<Integer> range = Range.between(5, 10);
        assertEquals(0, range.elementCompareTo(10));
    }

    @Test
    public void testElementCompareTo_NullElement() {
        Range<Integer> range = Range.between(5, 10);
        assertThrows(NullPointerException.class, () -> range.elementCompareTo(null));
    }

    @Test
    public void testElementCompareTo_ElementBeforeRangeWithCustomComparator() {
        Range<String> range = Range.between("b", "e", String.CASE_INSENSITIVE_ORDER);
        assertEquals(-1, range.elementCompareTo("a"));
    }

    @Test
    public void testElementCompareTo_ElementAfterRangeWithCustomComparator() {
        Range<String> range = Range.between("b", "e", String.CASE_INSENSITIVE_ORDER);
        assertEquals(1, range.elementCompareTo("f"));
    }

    @Test
    public void testElementCompareTo_ElementWithinRangeWithCustomComparator() {
        Range<String> range = Range.between("b", "e", String.CASE_INSENSITIVE_ORDER);
        assertEquals(0, range.elementCompareTo("c"));
    }

    @Test
    public void testElementCompareTo_SingleElementRange_ElementBefore() {
        Range<Integer> range = Range.is(5);
        assertEquals(-1, range.elementCompareTo(3));
    }

    @Test
    public void testElementCompareTo_SingleElementRange_ElementAfter() {
        Range<Integer> range = Range.is(5);
        assertEquals(1, range.elementCompareTo(7));
    }

    @Test
    public void testElementCompareTo_SingleElementRange_ElementEqual() {
        Range<Integer> range = Range.is(5);
        assertEquals(0, range.elementCompareTo(5));
    }
}
// ``````java
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.BeforeEach;
// import static org.junit.jupiter.api.Assertions.*;
// 
// public class RangeQwen_ZS5Test {
//     
//     private Range<Integer> range;
//     
//     @BeforeEach
//     void setUp() {
//         range = Range.between(5, 10);
//     }
//     
//     @Test
//     void testElementCompareTo_ElementIsNull_ThrowsNullPointerException() {
//         assertThrows(NullPointerException.class, () -> {
//             range.elementCompareTo(null);
//         });
//     }
//     
//     @Test
//     void testElementCompareTo_ElementIsBeforeRange_ReturnsNegativeOne() {
//         assertEquals(-1, range.elementCompareTo(3));
//     }
//     
//     @Test
//     void testElementCompareTo_ElementIsAfterRange_ReturnsPositiveOne() {
//         assertEquals(1, range.elementCompareTo(15));
//     }
//     
//     @Test
//     void testElementCompareTo_ElementIsWithinRange_ReturnsZero() {
//         assertEquals(0, range.elementCompareTo(7));
//     }
//     
//     @Test
//     void testElementCompareTo_ElementEqualsMinimum_ReturnsZero() {
//         assertEquals(0, range.elementCompareTo(5));
//     }
//     
//     @Test
//     void testElementCompareTo_ElementEqualsMaximum_ReturnsZero() {
//         assertEquals(0, range.elementCompareTo(10));
//     }
//     
//     @Test
//     void testElementCompareTo_ElementJustBeforeMinimum_ReturnsNegativeOne() {
//         assertEquals(-1, range.elementCompareTo(4));
//     }
//     
//     @Test
//     void testElementCompareTo_ElementJustAfterMaximum_ReturnsPositiveOne() {
//         assertEquals(1, range.elementCompareTo(11));
//     }
//     
//     @Test
//     void testElementCompareTo_SingleElementRange_ElementEqualsTheRange_ReturnsZero() {
//         Range<Integer> singleElementRange = Range.is(5);
//         assertEquals(0, singleElementRange.elementCompareTo(5));
//     }
//     
//     @Test
//     void testElementCompareTo_SingleElementRange_ElementBefore_ReturnsNegativeOne() {
//         Range<Integer> singleElementRange = Range.is(5);
//         assertEquals(-1, singleElementRange.elementCompareTo(3));
//     }
//     
//     @Test
//     void testElementCompareTo_SingleElementRange_ElementAfter_ReturnsPositiveOne() {
//         Range<Integer> singleElementRange = Range.is(5);
//         assertEquals(1, singleElementRange.elementCompareTo(7));
//     }
//     
//     @Test
//     void testElementCompareTo_WithStringValues_ElementBefore_ReturnsNegativeOne() {
//         Range<String> stringRange = Range.between("b", "d");
//         assertEquals(-1, stringRange.elementCompareTo("a"));
//     }
//     
//     @Test
//     void testElementCompareTo_WithStringValues_ElementAfter_ReturnsPositiveOne() {
//         Range<String> stringRange = Range.between("b", "d");
//         assertEquals(1, stringRange.elementCompareTo("e"));
//     }
//     
//     @Test
//     void testElementCompareTo_WithStringValues_ElementWithin_ReturnsZero() {
//         Range<String> stringRange = Range.between("b", "d");
//         assertEquals(0, stringRange.elementCompareTo("c"));
//     }
// }
// ```