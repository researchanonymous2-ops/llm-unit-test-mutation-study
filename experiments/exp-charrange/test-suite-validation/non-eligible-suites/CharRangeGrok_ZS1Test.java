package org.apache.commons.lang3;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeGrok_ZS1Test {

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
        CharRange range = CharRange.isIn('a', 'c');
        CharRange other = CharRange.isIn('b', 'd');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_Equal() {
        CharRange range = CharRange.isIn('a', 'c');
        CharRange other = CharRange.isIn('a', 'c');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_SingleChar() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.is('b');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNonNegated_True() {
        CharRange range = CharRange.isNotIn('a', 'c');
        CharRange other = CharRange.isIn('d', 'e');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNonNegated_False() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'c');
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
        CharRange other = CharRange.isNot('b');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_True() {
        CharRange range = CharRange.isNotIn('b', 'y');
        CharRange other = CharRange.isNotIn('a', 'z');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_False() {
        CharRange range = CharRange.isNotIn('a', 'c');
        CharRange other = CharRange.isNotIn('b', 'd');
        assertFalse(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_Equal() {
        CharRange range = CharRange.isNotIn('a', 'c');
        CharRange other = CharRange.isNotIn('a', 'c');
        assertTrue(range.contains(other));
    }

    @Test
    void testContains_NegatedContainsNegated_SingleChar() {
        CharRange range = CharRange.isNotIn('b', 'y');
        CharRange other = CharRange.isNot('a');
        assertTrue(range.contains(other));
    }
}
// ```