package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.*;

import com.thealgorithms.others.Verhoeff;

import org.junit.jupiter.api.Test;

public class VerhoeffGrok_OS2Test {

   @Test
   void testVerhoeffCheck_Valid_Zero() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_Valid_Fifteen() {
       assertTrue(Verhoeff.verhoeffCheck("15"));
   }

   @Test
   void testVerhoeffCheck_Valid_TwoThreeSixThree() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_Invalid_One() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
   }

   @Test
   void testVerhoeffCheck_Invalid_OneFour() {
       assertFalse(Verhoeff.verhoeffCheck("14"));
   }

   @Test
   void testVerhoeffCheck_Invalid_TwoThreeSixFour() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
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
   void testVerhoeffCheck_MixedDigitsAndLetters() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("12a"));
   }
}
