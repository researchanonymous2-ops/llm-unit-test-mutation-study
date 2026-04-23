package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesQwen_POT4Test {

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
    public void testNextPrime_T3_inputIsThree() {
        int result = Primes.nextPrime(3);
        assertTrue(result >= 3);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T4_inputIsSix() {
        int result = Primes.nextPrime(6);
        assertTrue(result >= 6);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T5_inputIsFour() {
        int result = Primes.nextPrime(4);
        assertTrue(result >= 4);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T6_inputIsFive() {
        int result = Primes.nextPrime(5);
        assertTrue(result >= 5);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T7_firstCheckInLoop() {
        int result = Primes.nextPrime(17);
        assertTrue(result >= 17);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T8_secondCheckInLoop() {
        int result = Primes.nextPrime(19);
        assertTrue(result >= 19);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_T9_fullLoopIteration() {
        int result = Primes.nextPrime(25);
        assertTrue(result >= 25);
        assertTrue(Primes.isPrime(result));
    }
}
// ```