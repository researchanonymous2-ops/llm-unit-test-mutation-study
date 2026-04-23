package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesQwen_POT2Test {

    @Test
    public void testNextPrime_T0_negativeInput() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_T1_inputIsTwo() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_T2_inputIsOne() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_T3_primeInput() {
        int result = Primes.nextPrime(7);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 7);
    }

    @Test
    public void testNextPrime_T4_remZero() {
        int result = Primes.nextPrime(9);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 9);
    }

    @Test
    public void testNextPrime_T5_remOne() {
        int result = Primes.nextPrime(10);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 10);
    }

    @Test
    public void testNextPrime_T6_remTwo() {
        int result = Primes.nextPrime(8);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 8);
    }

    @Test
    public void testNextPrime_T7_firstCheckInLoop() {
        int result = Primes.nextPrime(15);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 15);
    }

    @Test
    public void testNextPrime_T8_secondCheckInLoop() {
        int result = Primes.nextPrime(25);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 25);
    }

    @Test
    public void testNextPrime_T9_fullLoopIteration() {
        int result = Primes.nextPrime(119);
        assertTrue(Primes.isPrime(result));
        assertTrue(result >= 119);
    }
}
// ```