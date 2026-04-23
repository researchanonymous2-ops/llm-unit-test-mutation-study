package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffQwen_OS1Test {

   @Test
   void testVerhoeffCheck_validInput() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_invalidInput() {
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
   void testVerhoeffCheck_longValidInput() {
       assertTrue(Verhoeff.verhoeffCheck("123451234512345"));
   }

   @Test
   void testVerhoeffCheck_longInvalidInput() {
       assertFalse(Verhoeff.verhoeffCheck("123451234512346"));
   }

   @Test
   void testVerhoeffCheck_allZeros() {
       assertTrue(Verhoeff.verhoeffCheck("0000"));
   }

   @Test
   void testVerhoeffCheck_containsNonDigit() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a5"));
   }

   @Test
   void testVerhoeffCheck_nullInput() {
       assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
   }

   @Test
   void testVerhoeffCheck_emptyString() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
   }
}
