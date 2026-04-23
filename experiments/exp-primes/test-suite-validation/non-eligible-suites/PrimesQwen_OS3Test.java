package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.junit.jupiter.api.Test;

public class PrimesQwen_OS3Test {

   @Test
   void testNextPrime_negativeInput() {
       assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
       assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-100));
   }

   @Test
   void testNextPrime_zero() {
       assertEquals(2, Primes.nextPrime(0));
   }

   @Test
   void testNextPrime_one() {
       assertEquals(2, Primes.nextPrime(1));
   }

   @Test
   void testNextPrime_two() {
       assertEquals(2, Primes.nextPrime(2));
   }

   @Test
   void testNextPrime_smallNonPrime() {
       assertEquals(5, Primes.nextPrime(4));
       assertEquals(7, Primes.nextPrime(6));
       assertEquals(11, Primes.nextPrime(9));
   }

   @Test
   void testNextPrime_smallPrime() {
       assertEquals(3, Primes.nextPrime(3));
       assertEquals(5, Primes.nextPrime(5));
       assertEquals(7, Primes.nextPrime(7));
   }

   @Test
   void testNextPrime_largerNonPrime() {
       assertEquals(101, Primes.nextPrime(99));
       assertEquals(103, Primes.nextPrime(100));
       assertEquals(107, Primes.nextPrime(105));
   }

   @Test
   void testNextPrime_largerPrime() {
       assertEquals(101, Primes.nextPrime(101));
       assertEquals(103, Primes.nextPrime(103));
       assertEquals(107, Primes.nextPrime(107));
   }

   @Test
   void testNextPrime_edgeCaseBeforeLargeGap() {
       assertEquals(29, Primes.nextPrime(28));
       assertEquals(31, Primes.nextPrime(29));
   }

   @Test
   void testNextPrime_afterLargePrimeGap() {
       assertEquals(541, Primes.nextPrime(528)); // 540 is composite
   }
}
