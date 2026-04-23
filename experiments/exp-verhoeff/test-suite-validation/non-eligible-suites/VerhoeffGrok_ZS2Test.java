package com.thealgorithms.others;

package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_ZS2Test {

   @Test
   void testVerhoeffCheck_ValidSingleDigit() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_ValidMultipleDigits() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
       assertTrue(Verhoeff.verhoeffCheck("123456789"));
   }

   @Test
   void testVerhoeffCheck_InvalidSingleDigit() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
   }

   @Test
   void testVerhoeffCheck_InvalidMultipleDigits() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
       assertFalse(Verhoeff.verhoeffCheck("123456788"));
   }

   @Test
   void testVerhoeffCheck_EmptyString() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
   }

   @Test
   void testVerhoeffCheck_NullInput() {
       assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
   }

   @Test
   void testVerhoeffCheck_NonDigitInput() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("12 3"));
   }

   @Test
   void testVerhoeffCheck_LongValidInput() {
       assertTrue(Verhoeff.verhoeffCheck("8473643095483728456789"));
   }

   @Test
   void testVerhoeffCheck_LongInvalidInput() {
       assertFalse(Verhoeff.verhoeffCheck("8473643095483728456788"));
   }
}
