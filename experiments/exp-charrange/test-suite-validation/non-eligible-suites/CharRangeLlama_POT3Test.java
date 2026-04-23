package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_POT3Test {

    @Test
    public void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains((CharRange) null));
    }

    @Test
    public void testContains_BothNegated_Included() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegated_NotIncluded() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_CurrentNegated_RangeNotNegated_Excluded() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_CurrentNegated_RangeNotNegated_NotExcluded() {
        CharRange range1 = CharRange.isNotIn('a', 'e');
        CharRange range2 = CharRange.isIn('b', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_CurrentNotNegated_RangeNegated_FullRange() {
        CharRange range1 = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange range2 = CharRange.isNot('a');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_CurrentNotNegated_RangeNegated_NotFullRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_Included() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_NotIncluded() {
        CharRange range1 = CharRange.isIn('a', 'e');
        CharRange range2 = CharRange.isIn('b', 'z');
        assertFalse(range1.contains(range2));
    }
}
// ```