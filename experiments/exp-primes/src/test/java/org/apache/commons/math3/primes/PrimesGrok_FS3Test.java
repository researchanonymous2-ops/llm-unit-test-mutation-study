package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;

public class PrimesGrok_FS3Test {

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
   void testNextPrime_WithThree() {
       assertEquals(3, Primes.nextPrime(3));
   }

   @Test
   void testNextPrime_WithFour() {
       assertEquals(5, Primes.nextPrime(4));
   }

   @Test
   void testNextPrime_WithFive() {
       assertEquals(5, Primes.nextPrime(5));
   }

   @Test
   void testNextPrime_WithSix() {
       assertEquals(7, Primes.nextPrime(6));
   }

   @Test
   void testNextPrime_WithEight() {
       assertEquals(11, Primes.nextPrime(8));
   }

   @Test
   void testNextPrime_WithNine() {
       assertEquals(11, Primes.nextPrime(9));
   }

   @Test
   void testNextPrime_WithTen() {
       assertEquals(11, Primes.nextPrime(10));
   }

   @Test
   void testNextPrime_WithEleven() {
       assertEquals(11, Primes.nextPrime(11));
   }

   @Test
   void testNextPrime_WithTwelve() {
       assertEquals(13, Primes.nextPrime(12));
   }

   @Test
   void testNextPrime_WithHundred() {
       assertEquals(101, Primes.nextPrime(100));
   }

   @Test
   void testNextPrime_WithNegativeInputThrowsException() {
       assertThrows(MathIllegalArgumentException.class,
           () -> Primes.nextPrime(-1));
   }

   @Test
   void testNextPrime_WithNegativeTwoThrowsException() {
       assertThrows(MathIllegalArgumentException.class,
           () -> Primes.nextPrime(-2));
   }
}
