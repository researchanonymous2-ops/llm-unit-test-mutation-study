package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_COC5Test {

    @Test
    public void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains((CharRange) null));
    }

    @Test
    public void testContains_BothNegated_Contained() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegated_NotContained() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegated_RangeNotNegated_Contained() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('A', 'Z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNegated_RangeNotNegated_NotContained() {
        CharRange range1 = CharRange.isNotIn('a', 'd');
        CharRange range2 = CharRange.isIn('c', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_ThisNotNegated_RangeNegated() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_Contained() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_NotContained() {
        CharRange range1 = CharRange.isIn('b', 'y');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }
}
// ```