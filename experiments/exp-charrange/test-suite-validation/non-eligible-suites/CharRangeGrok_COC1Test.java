package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_COC1Test {

    @Test
    void testContains_NullRange() {
        CharRange charRange = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> charRange.contains(null));
    }

    @Test
    void testContains_BothNegated_Contains() {
        CharRange thisRange = CharRange.isNotIn('c', 'w');
        CharRange otherRange = CharRange.isNotIn('a', 'z');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_BothNegated_NotContains() {
        CharRange thisRange = CharRange.isNotIn('a', 'z');
        CharRange otherRange = CharRange.isNotIn('c', 'w');
        assertFalse(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNegated_RangeNot_Contains() {
        CharRange thisRange = CharRange.isNotIn('a', 'z');
        CharRange otherRange = CharRange.isIn('b', 'y');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNegated_RangeNot_NotContains() {
        CharRange thisRange = CharRange.isNotIn('a', 'z');
        CharRange otherRange = CharRange.isIn('A', 'Z');
        assertFalse(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNot_RangeNegated_Contains() {
        CharRange thisRange = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange otherRange = CharRange.isNotIn('a', 'z');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNot_RangeNegated_NotContains() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange otherRange = CharRange.isNotIn('b', 'y');
        assertFalse(thisRange.contains(otherRange));
    }

    @Test
    void testContains_BothNot_Contains() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange otherRange = CharRange.isIn('b', 'y');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_BothNot_NotContains() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange otherRange = CharRange.isIn('A', 'Z');
        assertFalse(thisRange.contains(otherRange));
    }
}
// ```