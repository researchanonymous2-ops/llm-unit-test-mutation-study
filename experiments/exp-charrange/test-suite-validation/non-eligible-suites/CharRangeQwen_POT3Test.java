package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_POT3Test {

    @Test
    public void testContains_nullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_bothNegated_true() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_bothNegated_false() {
        CharRange range1 = CharRange.isNotIn('c', 'x');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_thisNegated_rangeNotNegated_noOverlap() {
        CharRange range1 = CharRange.isNotIn('d', 'w');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_thisNegated_rangeNotNegated_overlapping() {
        CharRange range1 = CharRange.isNotIn('d', 'w');
        CharRange range2 = CharRange.isIn('e', 'f');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_thisNotNegated_rangeNegated_fullRange() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_thisNotNegated_rangeNegated_notFullRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('c', 'x');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_bothNotNegated_true() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('c', 'x');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_bothNotNegated_false() {
        CharRange range1 = CharRange.isIn('c', 'x');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }
}
// ```