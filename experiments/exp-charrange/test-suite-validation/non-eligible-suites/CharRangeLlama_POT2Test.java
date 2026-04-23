package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_POT2Test {

    @Test
    public void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_BothNegated_Included() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('d', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegated_NotIncluded() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegated_RangeNotNegated_Excluded() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('d', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegated_RangeNotNegated_NotExcluded() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNotNegated_RangeNegated_Included() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('d', 'x');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNotNegated_RangeNegated_NotIncluded() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_Included() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('d', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_NotIncluded() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }
}
// ```