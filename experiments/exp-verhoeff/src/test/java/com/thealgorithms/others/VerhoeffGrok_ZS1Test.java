package com.thealgorithms.others;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerhoeffGrok_ZS1Test {

   @Test
   void testVerhoeffCheck_valid() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_invalid() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
   }

   @Test
   void testVerhoeffCheck_singleDigitValid() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_singleDigitInvalid() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
   }

   @Test
   void testVerhoeffCheck_longerValid() {
       assertTrue(Verhoeff.verhoeffCheck("1234567890"));
   }

   @Test
   void testVerhoeffCheck_longerInvalid() {
       assertFalse(Verhoeff.verhoeffCheck("1234567891"));
   }

   @Test
   void testVerhoeffCheck_null() {
       assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
   }

   @Test
   void testVerhoeffCheck_nonDigits() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
   }

   @Test
   void testVerhoeffCheck_emptyString() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
   }

   @Test
   void testVerhoeffCheck_withSpaces() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123 456"));
   }

   @Test
   void testVerhoeffCheck_withSpecialChars() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123!"));
   }
}
