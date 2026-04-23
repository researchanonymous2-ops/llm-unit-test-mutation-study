package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.*;
import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_OS4Test {

   @Test
   void testVerhoeffCheck_ValidSingleDigit() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_ValidExample() {
       assertTrue(Verhoeff.verhoeffCheck("2363"));
   }

   @Test
   void testVerhoeffCheck_ValidGenerated() {
       assertTrue(Verhoeff.verhoeffCheck("1234567890"));
   }

   @Test
   void testVerhoeffCheck_InvalidExample() {
       assertFalse(Verhoeff.verhoeffCheck("2364"));
   }

   @Test
   void testVerhoeffCheck_InvalidModified() {
       assertFalse(Verhoeff.verhoeffCheck("1234567891"));
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
   void testVerhoeffCheck_NonDigitCharacters() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("abc"));
   }

   @Test
   void testVerhoeffCheck_MixedCharacters() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123a"));
   }

   @Test
   void testVerhoeffCheck_WithSpaces() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123 456"));
   }
}
