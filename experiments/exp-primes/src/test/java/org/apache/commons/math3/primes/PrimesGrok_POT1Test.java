package org.apache.commons.math3.primes;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class PrimesGrok_POT1Test {

    @Test
    public void testNextPrime_NegativeInput() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_InputTwo() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_InputOne() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_PrimeBeforeLoop() {
        int result = Primes.nextPrime(5);
        assertEquals(5, result);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_RemZeroAdjustment() {
        int result = Primes.nextPrime(9);
        assertEquals(11, result);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_RemOneAdjustment() {
        int result = Primes.nextPrime(25);
        assertEquals(29, result);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_RemTwoNoAdjustment() {
        int result = Primes.nextPrime(11);
        assertEquals(11, result);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_FirstCheckInLoop() {
        int result = Primes.nextPrime(32);
        assertEquals(37, result);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_SecondCheckInLoop() {
        int result = Primes.nextPrime(32);
        assertEquals(37, result);
        assertTrue(Primes.isPrime(result));
    }

    @Test
    public void testNextPrime_MultipleIterations() {
        int result = Primes.nextPrime(115);
        assertEquals(127, result);
        assertTrue(Primes.isPrime(result));
    }
}
// ```