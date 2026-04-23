package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharRangeGrok_COC2Test {

    @Test
    void testContains_NullRange() {
        CharRange charRange = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> charRange.contains(null));
    }

    @Test
    void testContains_BothNegated() {
        CharRange thisRange = CharRange.isNotIn('b', 'd');
        CharRange otherRange = CharRange.isNotIn('a', 'e');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNegatedOtherNot() {
        CharRange thisRange = CharRange.isNotIn('c', 'f');
        CharRange otherRange = CharRange.isIn('a', 'b');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNotNegatedOtherNegated() {
        CharRange thisRange = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange otherRange = CharRange.isNot('a');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_BothNotNegated() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange otherRange = CharRange.isIn('b', 'y');
        assertTrue(thisRange.contains(otherRange));
    }
}
// ```