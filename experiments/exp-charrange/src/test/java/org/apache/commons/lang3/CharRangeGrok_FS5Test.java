package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;

public class CharRangeGrok_FS5Test {

    @Test
    void testContains_NullRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        assertThrows(IllegalArgumentException.class, () -> outer.contains(null));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_True() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'y');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_False() {
        CharRange outer = CharRange.isIn('a', 'c');
        CharRange inner = CharRange.isIn('b', 'd');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_SameRange() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_NonNegatedContainsNonNegated_LargerRange() {
        CharRange outer = CharRange.isIn('b', 'y');
        CharRange inner = CharRange.isIn('a', 'z');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_NonNegatedContainsNegated_True() {
        CharRange outer = CharRange.isIn('\u0000', Character.MAX_VALUE);
        CharRange inner = CharRange.isNotIn('m', 'p');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_NonNegatedContainsNegated_False() {
        CharRange outer = CharRange.isIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_NegatedContainsNegated_True() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('a', 'z');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_NegatedContainsNegated_False() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isNotIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_NegatedContainsNonNegated_True() {
        CharRange outer = CharRange.isNotIn('m', 'p');
        CharRange inner = CharRange.isIn('a', 'c');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_NegatedContainsNonNegated_False() {
        CharRange outer = CharRange.isNotIn('a', 'z');
        CharRange inner = CharRange.isIn('b', 'y');
        assertFalse(outer.contains(inner));
    }

    @Test
    void testContains_SingleCharNonNegatedContainsSingleChar() {
        CharRange outer = CharRange.is('a');
        CharRange inner = CharRange.is('a');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_SingleCharNegatedContainsSingleChar() {
        CharRange outer = CharRange.isNot('a');
        CharRange inner = CharRange.isNot('a');
        assertTrue(outer.contains(inner));
    }

    @Test
    void testContains_InvertedRange() {
        CharRange outer = CharRange.isIn('z', 'a'); // Internamente troca para 'a'-'z'
        CharRange inner = CharRange.isIn('b', 'y');
        assertTrue(outer.contains(inner));
    }
}
// ```