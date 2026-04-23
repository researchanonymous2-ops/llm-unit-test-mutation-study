package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_COC4Test {

    @Test
    void testContains_nullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_bothNegated_true() {
        CharRange range1 = CharRange.isNotIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    void testContains_bothNegated_false() {
        CharRange range1 = CharRange.isNotIn('b', 'y');
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_thisNegated_parameterNot_negatedDisjoint() {
        CharRange range1 = CharRange.isNotIn('d', 'f');
        CharRange range2 = CharRange.isIn('a', 'c');
        assertTrue(range1.contains(range2));
    }

    @Test
    void testContains_thisNegated_parameterNot_negatedOverlapping() {
        CharRange range1 = CharRange.isNotIn('d', 'f');
        CharRange range2 = CharRange.isIn('e', 'g');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_thisNotNegated_parameterNegated_fullRange() {
        CharRange range1 = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange range2 = CharRange.isNotIn('a', 'z');
        assertTrue(range1.contains(range2));
    }

    @Test
    void testContains_thisNotNegated_parameterNegated_notFullRange() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isNotIn('b', 'y');
        assertFalse(range1.contains(range2));
    }

    @Test
    void testContains_bothNotNegated_true() {
        CharRange range1 = CharRange.isIn('a', 'z');
        CharRange range2 = CharRange.isIn('b', 'y');
        assertTrue(range1.contains(range2));
    }

    @Test
    void testContains_bothNotNegated_false() {
        CharRange range1 = CharRange.isIn('b', 'y');
        CharRange range2 = CharRange.isIn('a', 'z');
        assertFalse(range1.contains(range2));
    }
}
// ```