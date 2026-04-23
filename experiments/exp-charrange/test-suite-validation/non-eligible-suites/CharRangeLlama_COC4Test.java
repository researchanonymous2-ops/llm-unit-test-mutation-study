package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_COC4Test {

    @Test
    public void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains((CharRange) null));
    }

    @Test
    public void testContains_BothNegated_InRange() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNegated_OutOfRange() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_FirstNegatedSecondNot_OutOfRange() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_FirstNegatedSecondNot_InRange() {
        CharRange range1 = CharRange.isNotIn('a', 'd');
        CharRange range2 = CharRange.isIn('e', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_FirstNotNegatedSecondNegated() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertFalse(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_InRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    public void testContains_BothNotNegated_OutOfRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('A', 'Z');
        assertFalse(range1.contains(range2));
    }
}
// ```