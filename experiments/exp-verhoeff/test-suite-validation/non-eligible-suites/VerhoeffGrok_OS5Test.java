package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_OS5Test {

   @Test
   void testVerhoeffCheck_ValidFourDigits() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_InvalidFourDigits() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
   }

   @Test
   void testVerhoeffCheck_ValidThreeDigits() {
       assertTrue(Verhoeff.verhoeffCheck("457"));
   }

   @Test
   void testVerhoeffCheck_InvalidThreeDigits() {
       assertFalse(Verhoeff.verhoeffCheck("458"));
   }

   @Test
   void testVerhoeffCheck_ValidSingleDigit() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_InvalidSingleDigit() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
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
   void testVerhoeffCheck_NonDigitString() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
   }

   @Test
   void testVerhoeffCheck_StringWithSpaces() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("23 63"));
   }
}
