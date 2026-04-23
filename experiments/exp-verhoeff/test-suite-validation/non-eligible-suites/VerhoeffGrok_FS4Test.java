package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_FS4Test {

   @Test
   void testVerhoeffCheck_ValidSingleDigit() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_ValidMultiDigit() {
       assertTrue(Verhoeff.verhoeffCheck("123456789"));
   }

   @Test
   void testVerhoeffCheck_InvalidMultiDigit() {
       assertFalse(Verhoeff.verhoeffCheck("123456788"));
   }

   @Test
   void testVerhoeffCheck_InvalidShortString() {
       assertFalse(Verhoeff.verhoeffCheck("12"));
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
   void testVerhoeffCheck_ValidLongString() {
       assertTrue(Verhoeff.verhoeffCheck("9876543210"));
   }
}
