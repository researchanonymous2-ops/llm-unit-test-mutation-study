package com.thealgorithms.others;

package com.thealgorithms.others;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffGrok_ZS3Test {

   @Test
   void testVerhoeffCheck_ValidSingleDigit() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_InvalidSingleDigit() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
   }

   @Test
   void testVerhoeffCheck_ValidFourDigits() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_InvalidFourDigits() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
   }

   @Test
   void testVerhoeffCheck_ValidTwoDigits() {
       assertTrue(Verhoeff.verhoeffCheck("00"));
   }

   @Test
   void testVerhoeffCheck_InvalidTwoDigits() {
       assertFalse(Verhoeff.verhoeffCheck("01"));
   }

   @Test
   void testVerhoeffCheck_NullInput() {
       assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
   }

   @Test
   void testVerhoeffCheck_EmptyString() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
   }

   @Test
   void testVerhoeffCheck_NonDigitInput() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
   }

   @Test
   void testVerhoeffCheck_MixedInput() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
   }

   @Test
   void testVerhoeffCheck_WithLeadingZero() {
       assertFalse(Verhoeff.verhoeffCheck("02363"));
   }
}
