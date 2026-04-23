package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;

public class PrimesGrok_FS4Test {

   @Test
   void testNextPrime_WithZero() {
       assertEquals(2, Primes.nextPrime(0));
   }

   @Test
   void testNextPrime_WithOne() {
       assertEquals(2, Primes.nextPrime(1));
   }

   @Test
   void testNextPrime_WithTwo() {
       assertEquals(2, Primes.nextPrime(2));
   }

   @Test
   void testNextPrime_WithPrime() {
       assertEquals(7, Primes.nextPrime(7));
   }

   @Test
   void testNextPrime_WithEvenNumber() {
       assertEquals(5, Primes.nextPrime(4));
   }

   @Test
   void testNextPrime_WithOddNumber() {
       assertEquals(11, Primes.nextPrime(10));
   }

   @Test
   void testNextPrime_WithNegative() {
       assertThrows(MathIllegalArgumentException.class,
           () -> Primes.nextPrime(-1));
   }

   @Test
   void testNextPrime_WithNegativeLarge() {
       assertThrows(MathIllegalArgumentException.class,
           () -> Primes.nextPrime(-10));
   }
}
