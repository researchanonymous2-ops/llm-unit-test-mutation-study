package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_FS3Test {

   @Test
   void testVerhoeffCheck_ValidSingleDigit() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_ValidTwoDigits() {
       assertTrue(Verhoeff.verhoeffCheck("15"));
   }

   @Test
   void testVerhoeffCheck_ValidLongerNumber() {
       assertTrue(Verhoeff.verhoeffCheck("123456789"));
   }

   @Test
   void testVerhoeffCheck_InvalidSingleDigit() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
   }

   @Test
   void testVerhoeffCheck_InvalidTwoDigits() {
       assertFalse(Verhoeff.verhoeffCheck("16"));
   }

   @Test
   void testVerhoeffCheck_InvalidLongerNumber() {
       assertFalse(Verhoeff.verhoeffCheck("123456788"));
   }

   @Test
   void testVerhoeffCheck_NullInputThrowsException() {
       assertThrows(NullPointerException.class,
           () -> Verhoeff.verhoeffCheck(null));
   }

   @Test
   void testVerhoeffCheck_EmptyStringThrowsException() {
       assertThrows(IllegalArgumentException.class,
           () -> Verhoeff.verhoeffCheck(""));
   }

   @Test
   void testVerhoeffCheck_NonDigitInputThrowsException() {
       assertThrows(IllegalArgumentException.class,
           () -> Verhoeff.verhoeffCheck("12B4"));
   }

   @Test
   void testVerhoeffCheck_AlphabeticInputThrowsException() {
       assertThrows(IllegalArgumentException.class,
           () -> Verhoeff.verhoeffCheck("ABC"));
   }

   @Test
   void testVerhoeffCheck_SpecialCharacterInputThrowsException() {
       assertThrows(IllegalArgumentException.class,
           () -> Verhoeff.verhoeffCheck("123@"));
   }
}
