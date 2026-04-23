package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeQwen_POT5Test {

    @Test
    public void testContains_NullRange_ThrowsException() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    public void testContains_BothNegated_TrueWhenThisWithinRange() {
        CharRange range1 = CharRange.isNotIn('c', 'f'); // ^c-f
        CharRange range2 = CharRange.isNotIn('b', 'g'); // ^b-g
        assertTrue(range1.contains(range2)); // c-f within b-g
    }

    @Test
    public void testContains_BothNegated_FalseWhenThisOutsideRange() {
        CharRange range1 = CharRange.isNotIn('a', 'd'); // ^a-d
        CharRange range2 = CharRange.isNotIn('e', 'h'); // ^e-h
        assertFalse(range1.contains(range2)); // a-d does not contain e-h
    }

    @Test
    public void testContains_ThisNegatedParamNormal_TrueWhenNoOverlap() {
        CharRange range1 = CharRange.isNotIn('c', 'f'); // ^c-f (0-b, g-MAX)
        CharRange range2 = CharRange.isIn('a', 'b');    // a-b
        assertTrue(range1.contains(range2)); // a-b is in ^c-f
    }

    @Test
    public void testContains_ThisNegatedParamNormal_FalseWhenOverlap() {
        CharRange range1 = CharRange.isNotIn('c', 'f'); // ^c-f
        CharRange range2 = CharRange.isIn('d', 'e');    // d-e
        assertFalse(range1.contains(range2)); // d-e overlaps with negated part
    }

    @Test
    public void testContains_ThisNormalParamNegated_TrueWhenFullRange() {
        CharRange range1 = CharRange.isIn((char)0, Character.MAX_VALUE); // full range
        CharRange range2 = CharRange.isNotIn('a', 'z'); // ^a-z
        assertTrue(range1.contains(range2)); // full range contains any negated range
    }

    @Test
    public void testContains_ThisNormalParamNegated_FalseWhenNotFullRange() {
        CharRange range1 = CharRange.isIn('b', 'y');        // b-y
        CharRange range2 = CharRange.isNotIn('c', 'x');     // ^c-x
        assertFalse(range1.contains(range2)); // b-y does not contain ^c-x
    }

    @Test
    public void testContains_BothNormal_TrueWhenThisContainsParam() {
        CharRange range1 = CharRange.isIn('a', 'z'); // a-z
        CharRange range2 = CharRange.isIn('d', 'm'); // d-m
        assertTrue(range1.contains(range2)); // a-z contains d-m
    }

    @Test
    public void testContains_BothNormal_FalseWhenThisDoesNotContainParam() {
        CharRange range1 = CharRange.isIn('a', 'm'); // a-m
        CharRange range2 = CharRange.isIn('n', 'z'); // n-z
        assertFalse(range1.contains(range2)); // a-m does not contain n-z
    }
}
// ```