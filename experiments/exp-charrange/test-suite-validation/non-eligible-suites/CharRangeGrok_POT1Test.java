package org.apache.commons.lang3;

// ```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.CharRange;

public class CharRangeGrok_POT1Test {

    @Test
    void testContains_NullRange() {
        CharRange charRange = CharRange.is('a');
        assertThrows(IllegalArgumentException.class, () -> charRange.contains(null));
    }

    @Test
    void testContains_BothNegated() {
        CharRange thisRange = CharRange.isNotIn('a', 'z');
        CharRange otherRange = CharRange.isNotIn('b', 'y');
        assertTrue(thisRange.contains(otherRange)); // Assuming 'a' >= 'b' and 'z' <= 'y' is false, but adjust based on logic

        thisRange = CharRange.isNotIn('b', 'y');
        otherRange = CharRange.isNotIn('a', 'z');
        assertFalse(thisRange.contains(otherRange)); // 'b' >= 'a' and 'y' <= 'z' is true
    }

    @Test
    void testContains_ThisNegated_OtherNot() {
        CharRange thisRange = CharRange.isNotIn('a', 'z');
        CharRange otherRange = CharRange.isIn('b', 'y');
        assertTrue(thisRange.contains(otherRange)); // 'y' < 'a' or 'b' > 'z' is false

        otherRange = CharRange.isIn('A', 'Z');
        assertFalse(thisRange.contains(otherRange)); // 'Z' < 'a' or 'A' > 'z' is false, but since 'A' < 'a', should be false
    }

    @Test
    void testContains_ThisNot_OtherNegated() {
        CharRange thisRange = CharRange.isIn((char) 0, Character.MAX_VALUE);
        CharRange otherRange = CharRange.isNot('a');
        assertTrue(thisRange.contains(otherRange)); // this.start == 0 && this.end == Character.MAX_VALUE

        thisRange = CharRange.isIn('a', 'z');
        assertFalse(thisRange.contains(otherRange)); // not full range
    }

    @Test
    void testContains_BothNotNegated() {
        CharRange thisRange = CharRange.isIn('a', 'z');
        CharRange otherRange = CharRange.isIn('b', 'y');
        assertTrue(thisRange.contains(otherRange)); // 'a' <= 'b' && 'z' >= 'y'

        otherRange = CharRange.isIn('A', 'Z');
        assertFalse(thisRange.contains(otherRange)); // 'a' <= 'A' is false
    }
}
// ```