package org.apache.commons.math3.primes;

// ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;

public class PrimesQwen_FS2Test {

    @Test
    void testNextPrime_negativeInput_throwsException() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-5));
    }

    @Test
    void testNextPrime_zero_returnsTwo() {
        assertEquals(2, Primes.nextPrime(0));
    }

    @Test
    void testNextPrime_one_returnsTwo() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    void testNextPrime_two_returnsTwo() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    void testNextPrime_primeInput_returnsSameNumber() {
        assertEquals(13, Primes.nextPrime(13));
    }

    @Test
    void testNextPrime_compositeInput_returnsNextPrime() {
        assertEquals(17, Primes.nextPrime(15));
    }

    @Test
    void testNextPrime_largeNonPrimeInput_returnsNextPrime() {
        assertEquals(101, Primes.nextPrime(99));
    }

    @Test
    void testNextPrime_inputJustBeforePrime_returnsPrime() {
        assertEquals(23, Primes.nextPrime(22));
    }

    @Test
    void testNextPrime_inputJustAfterPrime_returnsNextPrime() {
        assertEquals(31, Primes.nextPrime(24));
    }

    @Test
    void testNextPrime_smallEvenNumber_returnsNextPrime() {
        assertEquals(11, Primes.nextPrime(8));
    }
}
// ```