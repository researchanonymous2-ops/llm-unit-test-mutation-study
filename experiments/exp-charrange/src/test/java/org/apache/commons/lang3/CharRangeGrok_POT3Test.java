package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.CharRange;

public class CharRangeGrok_POT3Test {

    @Test
    void testContains_NullRange() {
        CharRange charRange = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> charRange.contains(null));
    }

    @Test
    void testContains_BothNegated() {
        CharRange thisRange = CharRange.isNotIn('b', 'd');
        CharRange otherRange = CharRange.isNotIn('a', 'e');
        assertTrue(thisRange.contains(otherRange)); // this.start=98('b') >= 97('a'), this.end=100('d') <= 101('e')

        thisRange = CharRange.isNotIn('a', 'c');
        otherRange = CharRange.isNotIn('b', 'd');
        assertFalse(thisRange.contains(otherRange)); // this.start=97('a') >= 98('b') is false
    }

    @Test
    void testContains_ThisNegatedOtherNot() {
        CharRange thisRange = CharRange.isNotIn('b', 'd');
        CharRange otherRange = CharRange.isIn('a', 'c');
        assertFalse(thisRange.contains(otherRange)); // range.end=99('c') < 98('b') is false, range.start=97('a') > 100('d') is false

        thisRange = CharRange.isNotIn('a', 'c');
        otherRange = CharRange.isIn('d', 'e');
        assertTrue(thisRange.contains(otherRange)); // range.end=101('e') < 97('a') is false, range.start=100('d') > 99('c') is true
    }

    @Test
    void testContains_ThisNotNegatedOtherNegated() {
        CharRange thisRange = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange otherRange = CharRange.isNot('a');
        assertTrue(thisRange.contains(otherRange)); // this.start == 0 && this.end == Character.MAX_VALUE

        thisRange = CharRange.isIn('a', 'z');
        otherRange = CharRange.isNot('b');
        assertFalse(thisRange.contains(otherRange)); // this.start != 0 or this.end != Character.MAX_VALUE
    }

    @Test
    void testContains_BothNotNegated() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange otherRange = CharRange.isIn('b', 'y');
        assertTrue(thisRange.contains(otherRange)); // this.start=97('a') <= 98('b'), this.end=122('z') >= 121('y')

        thisRange = CharRange.isIn('b', 'y');
        otherRange = CharRange.isIn('a', 'z');
        assertFalse(thisRange.contains(otherRange)); // this.start=98('b') <= 97('a') is false
    }
}
// ```