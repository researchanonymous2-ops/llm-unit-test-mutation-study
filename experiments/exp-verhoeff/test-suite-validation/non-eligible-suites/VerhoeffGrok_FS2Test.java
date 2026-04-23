package com.thealgorithms.others;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thealgorithms.others.Verhoeff;
import org.junit.jupiter.api.Test;

public class VerhoeffGrok_FS2Test {

   @Test
   void testVerhoeffCheck_ValidInput() {
       assertTrue(Verhoeff.verhoeffCheck("123456789"));
   }

   @Test
   void testVerhoeffCheck_InvalidInput() {
       assertFalse(Verhoeff.verhoeffCheck("123456788"));
   }

   @Test
   void testVerhoeffCheck_NullInput() {
       assertThrows(NullPointerException.class, () -> Verhoeff.verhoeffCheck(null));
   }

   @Test
   void testVerhoeffCheck_NonDigitInput() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck("123A"));
   }

   @Test
   void testVerhoeffCheck_EmptyString() {
       assertThrows(IllegalArgumentException.class, () -> Verhoeff.verhoeffCheck(""));
   }

   @Test
   void testVerhoeffCheck_SingleDigitValid() {
       assertTrue(Verhoeff.verhoeffCheck("0"));
   }

   @Test
   void testVerhoeffCheck_SingleDigitInvalid() {
       assertFalse(Verhoeff.verhoeffCheck("1"));
   }
}
