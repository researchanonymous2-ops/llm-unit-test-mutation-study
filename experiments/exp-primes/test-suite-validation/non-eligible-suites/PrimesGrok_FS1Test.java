package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;

public class PrimesGrok_FS1Test {

   @Test
   void testNextPrime_WithZero() {
       assertThrows(MathIllegalArgumentException.class,
           () -> Primes.nextPrime(0));
   }

   @Test
   void testNextPrime_WithNegative() {
       assertThrows(MathIllegalArgumentException.class,
           () -> Primes.nextPrime(-5));
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
   void testNextPrime_WithThree() {
       assertEquals(3, Primes.nextPrime(3));
   }

   @Test
   void testNextPrime_WithFour() {
       assertEquals(5, Primes.nextPrime(4));
   }

   @Test
   void testNextPrime_WithNine() {
       assertEquals(11, Primes.nextPrime(9));
   }

   @Test
   void testNextPrime_WithHundred() {
       assertEquals(101, Primes.nextPrime(100));
   }

   @Test
   void testNextPrime_WithLargeNumber() {
       assertEquals(997, Primes.nextPrime(996));
   }
}
