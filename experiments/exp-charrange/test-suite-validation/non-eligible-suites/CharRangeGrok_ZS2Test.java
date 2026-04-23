package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_ZS2Test {

    @Test
    void testContains_NullRange_ThrowsException() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_NonNegatedRange_Contained() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'y');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NonNegatedRange_NotContained() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('A', 'Z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NonNegatedRange_PartiallyContained() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('y', 'A');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NonNegatedRange_Equal() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('a', 'z');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NonNegatedRange_SingleChar() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.is('b');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedRange_InNonNegated_FullRange() {
        CharRange range = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange other = CharRange.isNot('a');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedRange_InNonNegated_NotFullRange() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isNot('b');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NonNegatedRange_InNegated() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('A', 'Z');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NonNegatedRange_InNegated_NotContained() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'y');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_BothNegated_Contained() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNotIn('b', 'y');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_BothNegated_NotContained() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNotIn('A', 'Z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_BothNegated_Equal() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNotIn('a', 'z');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedRange_InNegated() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNot('b');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_SingleChar_InNonNegated() {
        CharRange range = CharRange.is('a');
        CharRange other = CharRange.is('a');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_SingleChar_InNonNegated_NotContained() {
        CharRange range = CharRange.is('a');
        CharRange other = CharRange.is('b');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_SingleNegated_InNonNegated() {
        CharRange range = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange other = CharRange.isNot('a');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_SingleNegated_InNegated() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNot('b');
        assertTrue(range.contains(other));
    }
}
// ```