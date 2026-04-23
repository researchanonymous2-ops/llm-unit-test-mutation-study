package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_POT2Test {

    @Test
    public void testContains_NullRange() {
        CharRange cr = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> cr.contains(null));
    }

    @Test
    public void testContains_BothNegated_Inclusion() {
        CharRange cr = CharRange.isNotIn('b', 'd'); // negated, start='b', end='d'
        CharRange range = CharRange.isNotIn('a', 'e'); // negated, start='a', end='e'
        // cr.start='b' >= range.start='a' && cr.end='d' <= range.end='e' -> true
        assertTrue(cr.contains(range));
    }

    @Test
    public void testContains_BothNegated_NoInclusion() {
        CharRange cr = CharRange.isNotIn('b', 'd'); // negated, start='b', end='d'
        CharRange range = CharRange.isNotIn('c', 'f'); // negated, start='c', end='f'
        // cr.start='b' >= range.start='c' -> false
        assertFalse(cr.contains(range));
    }

    @Test
    public void testContains_ThisNegated_RangeNotNegated_Exclusion() {
        CharRange cr = CharRange.isNotIn('b', 'd'); // negated, start='b', end='d'
        CharRange range = CharRange.isIn('a', 'c'); // not negated, start='a', end='c'
        // range.end='c' < cr.start='b' -> true
        assertTrue(cr.contains(range));
    }

    @Test
    public void testContains_ThisNegated_RangeNotNegated_NoExclusion() {
        CharRange cr = CharRange.isNotIn('b', 'd'); // negated, start='b', end='d'
        CharRange range = CharRange.isIn('c', 'e'); // not negated, start='c', end='e'
        // range.end='e' >= cr.start='b' && range.start='c' <= cr.end='d' -> false
        assertFalse(cr.contains(range));
    }

    @Test
    public void testContains_ThisNotNegated_RangeNegated_FullRange() {
        CharRange cr = CharRange.isIn('\u0000', Character.MAX_VALUE); // not negated, full range
        CharRange range = CharRange.isNot('a'); // negated, start='a', end='a'
        // cr.start==0 && cr.end==Character.MAX_VALUE -> true
        assertTrue(cr.contains(range));
    }

    @Test
    public void testContains_ThisNotNegated_RangeNegated_NotFullRange() {
        CharRange cr = CharRange.isIn('a', 'z'); // not negated, start='a', end='z'
        CharRange range = CharRange.isNot('b'); // negated, start='b', end='b'
        // cr.start!='\u0000' || cr.end!=Character.MAX_VALUE -> false
        assertFalse(cr.contains(range));
    }

    @Test
    public void testContains_BothNotNegated_Inclusion() {
        CharRange cr = CharRange.isIn('a', 'z'); // not negated, start='a', end='z'
        CharRange range = CharRange.isIn('b', 'y'); // not negated, start='b', end='y'
        // cr.start='a' <= range.start='b' && cr.end='z' >= range.end='y' -> true
        assertTrue(cr.contains(range));
    }

    @Test
    public void testContains_BothNotNegated_NoInclusion() {
        CharRange cr = CharRange.isIn('a', 'z'); // not negated, start='a', end='z'
        CharRange range = CharRange.isIn('0', '9'); // not negated, start='0', end='9'
        // cr.start='a' > range.start='0' -> false
        assertFalse(cr.contains(range));
    }
}
// ```