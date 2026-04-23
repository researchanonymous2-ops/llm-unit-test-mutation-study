package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.CharRange;

public class CharRangeGrok_COC5Test {

    @Test
    void testContains_NullRange() {
        CharRange charRange = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> charRange.contains(null));
    }

    @Test
    void testContains_BothNegated_True() {
        CharRange thisRange = CharRange.isNotIn('b', 'z');
        CharRange range = CharRange.isNotIn('a', 'c');
        assertTrue(thisRange.contains(range));
    }

    @Test
    void testContains_BothNegated_False() {
        CharRange thisRange = CharRange.isNotIn('a', 'c');
        CharRange range = CharRange.isNotIn('b', 'z');
        assertFalse(thisRange.contains(range));
    }

    @Test
    void testContains_ThisNegatedRangeNot_True() {
        CharRange thisRange = CharRange.isNotIn('d', 'f');
        CharRange range = CharRange.isIn('a', 'c');
        assertTrue(thisRange.contains(range));
    }

    @Test
    void testContains_ThisNegatedRangeNot_False() {
        CharRange thisRange = CharRange.isNotIn('a', 'c');
        CharRange range = CharRange.isIn('b', 'd');
        assertFalse(thisRange.contains(range));
    }

    @Test
    void testContains_ThisNotRangeNegated_True() {
        CharRange thisRange = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange range = CharRange.isNot('a');
        assertTrue(thisRange.contains(range));
    }

    @Test
    void testContains_ThisNotRangeNegated_False() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange range = CharRange.isNot('b');
        assertFalse(thisRange.contains(range));
    }

    @Test
    void testContains_BothNot_True() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange range = CharRange.isIn('b', 'y');
        assertTrue(thisRange.contains(range));
    }

    @Test
    void testContains_BothNot_False() {
        CharRange thisRange = CharRange.isIn('a', 'c');
        CharRange range = CharRange.isIn('b', 'z');
        assertFalse(thisRange.contains(range));
    }
}
// ```