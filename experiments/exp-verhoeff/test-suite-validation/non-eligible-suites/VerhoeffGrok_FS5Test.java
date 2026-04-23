package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_FS5Test {

   @Test
   void testVerhoeffCheck_ValidSingleDigit() {
       assertTrue(Verhoeff.verhoeffCheck("14"));
   }

   @Test
   void testVerhoeffCheck_ValidThreeDigits() {
       assertTrue(Verhoeff.verhoeffCheck("1230"));
   }

   @Test
   void testVerhoeffCheck_ValidFourDigits() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_InvalidSingleDigit() {
       assertFalse(Verhoeff.verhoeffCheck("15"));
   }

   @Test
   void testVerhoeffCheck_InvalidThreeDigits() {
       assertFalse(Verhoeff.verhoeffCheck("1231"));
   }

   @Test
   void testVerhoeffCheck_InvalidFourDigits() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
   }

   @Test
   void testVerhoeffCheck_NonDigitInputThrowsException() {
       assertThrows(IllegalArgumentException.class,
           () -> Verhoeff.verhoeffCheck("12a3"));
   }

   @Test
   void testVerhoeffCheck_EmptyStringThrowsException() {
       assertThrows(IllegalArgumentException.class,
           () -> Verhoeff.verhoeffCheck(""));
   }

   @Test
   void testVerhoeffCheck_NullInputThrowsException() {
       assertThrows(NullPointerException.class,
           () -> Verhoeff.verhoeffCheck(null));
   }
}
