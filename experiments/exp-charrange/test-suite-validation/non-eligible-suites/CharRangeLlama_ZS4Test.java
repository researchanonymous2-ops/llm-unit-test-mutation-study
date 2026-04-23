package org.apache.commons.lang3;

// ```java
import org.apache.commons.lang3.CharRange;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharRangeLlama_ZS4Test {

    @Test
    public void testContains_NullRange() {
        CharRange range = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> range.contains((CharRange) null));
    }

    @Test
    public void testContains_SingleCharRange_Contained() {
        CharRange range = CharRange.is('a');
        CharRange other = CharRange.is('a');
        assertTrue(range.contains(other));
    }

    @Test
    public void testContains_SingleCharRange_NotContained() {
        CharRange range = CharRange.is('a');
        CharRange other = CharRange.is('b');
        assertFalse(range.contains(other));
    }

    @Test
    public void testContains_Range_Contained() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'y');
        assertTrue(range.contains(other));
    }

    @Test
    public void testContains_Range_NotContained() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'Z');
        assertFalse(range.contains(other));
    }

    @Test
    public void testContains_NegatedRange_Contained() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNotIn('b', 'y');
        assertFalse(range.contains(other));
    }

    @Test
    public void testContains_NegatedRange_NotContained() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'y');
        assertTrue(range.contains(other));
    }

    @Test
    public void testContains_NegatedRange_BothNegated() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isNotIn('b', 'y');
        assertFalse(range.contains(other));
    }

    @Test
    public void testContains_NegatedRange_OtherNegated() {
        CharRange range = CharRange.isIn('a', 'z');
        CharRange other = CharRange.isNotIn('b', 'y');
        assertFalse(range.contains(other));
    }

    @Test
    public void testContains_NegatedRange_ThisNegated_OtherNotNegated() {
        CharRange range = CharRange.isNotIn('a', 'z');
        CharRange other = CharRange.isIn('b', 'y');
        assertTrue(range.contains(other));
    }

    @Test
    public void testContains_EdgeCase_MinMax() {
        CharRange range = CharRange.isIn(Character.MIN_VALUE, Character.MAX_VALUE);
        CharRange other = CharRange.isIn('a', 'z');
        assertTrue(range.contains(other));
    }

    @Test
    public void testContains_Negated_EdgeCase_MinMax() {
        CharRange range = CharRange.isNotIn(Character.MIN_VALUE, Character.MAX_VALUE);
        CharRange other = CharRange.isIn('a', 'z');
        assertFalse(range.contains(other));
    }
}
// ```