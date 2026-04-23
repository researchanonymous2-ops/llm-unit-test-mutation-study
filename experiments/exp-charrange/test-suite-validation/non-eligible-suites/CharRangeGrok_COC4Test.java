package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.CharRange;

public class CharRangeGrok_COC4Test {

    @Test
    void testContains_NullRange() {
        CharRange charRange = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> charRange.contains(null));
    }

    @Test
    void testContains_BothNegated_True() {
        CharRange thisRange = CharRange.isNot('b');
        CharRange otherRange = CharRange.isNot('a');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_BothNegated_False() {
        CharRange thisRange = CharRange.isNot('a');
        CharRange otherRange = CharRange.isNot('b');
        assertFalse(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNegated_OtherNot_True() {
        CharRange thisRange = CharRange.isNot('a');
        CharRange otherRange = CharRange.is('b');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNegated_OtherNot_False() {
        CharRange thisRange = CharRange.isNot('a');
        CharRange otherRange = CharRange.is('a');
        assertFalse(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNot_OtherNegated_True() {
        CharRange thisRange = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange otherRange = CharRange.isNot('a');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_ThisNot_OtherNegated_False() {
        CharRange thisRange = CharRange.is('a');
        CharRange otherRange = CharRange.isNot('b');
        assertFalse(thisRange.contains(otherRange));
    }

    @Test
    void testContains_BothNot_True() {
        CharRange thisRange = CharRange.isIn('a', 'c');
        CharRange otherRange = CharRange.isIn('a', 'b');
        assertTrue(thisRange.contains(otherRange));
    }

    @Test
    void testContains_BothNot_False() {
        CharRange thisRange = CharRange.isIn('a', 'b');
        CharRange otherRange = CharRange.isIn('a', 'c');
        assertFalse(thisRange.contains(otherRange));
    }
}
// ```