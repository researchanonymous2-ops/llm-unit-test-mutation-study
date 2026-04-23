package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_ZS4Test {

    @Test
    void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains(null));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_True() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'y');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_False() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('0', '9');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_Equal() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('a', 'z');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_StartGreater() {
        CharRange range = CharRange.isIn('b', 'z');
        CharRange other = CharRange.isIn('a', 'z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_EndLess() {
        CharRange range = CharRange.isIn('a', 'y');
        CharRange other = CharRange.isIn('a', 'z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNegated_True() {
        CharRange range = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange other = CharRange.isNot('a');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNegated_False() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isNot('a');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNonNegated_True() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('0', '9');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNonNegated_False() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'y');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_True() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNotIn('b', 'y');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_False() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNotIn('0', '9');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_StartLess() {
        CharRange range = CharRange.isNotIn('b', 'z');
        CharRange other = CharRange.isNotIn('a', 'z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_EndGreater() {
        CharRange range = CharRange.isNotIn('a', 'y');
        CharRange other = CharRange.isNotIn('a', 'z');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_SingleCharContainsSingleChar() {
        CharRange range = CharRange.is('a');
        CharRange other = CharRange.is('a');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_SingleCharDoesNotContainDifferent() {
        CharRange range = CharRange.is('a');
        CharRange other = CharRange.is('b');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedSingleCharContainsNonNegated() {
        CharRange range = CharRange.isNot('a');
        CharRange other = CharRange.is('b');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedSingleCharDoesNotContainItself() {
        CharRange range = CharRange.isNot('a');
        CharRange other = CharRange.is('a');
        assertFalse(range.contains(other));
    }
}
// ```