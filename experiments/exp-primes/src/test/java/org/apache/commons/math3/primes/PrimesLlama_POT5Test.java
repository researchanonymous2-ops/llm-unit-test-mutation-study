package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesLlama_POT5Test {

    @Test
    public void testNextPrime_NegativeNumber() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_Two() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_One() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_PrimeNumber() {
        assertEquals(7, Primes.nextPrime(7));
    }

    @Test
    public void testNextPrime_NonPrimeNumberWithRemZero() {
        assertEquals(11, Primes.nextPrime(9));
    }

    @Test
    public void testNextPrime_NonPrimeNumberWithRemOne() {
        assertEquals(11, Primes.nextPrime(10));
    }

    @Test
    public void testNextPrime_NonPrimeNumberWithRemTwo() {
        assertEquals(11, Primes.nextPrime(8));
    }

    @Test
    public void testNextPrime_FirstPrimeInLoop() {
        assertEquals(7, Primes.nextPrime(6));
    }

    @Test
    public void testNextPrime_SecondPrimeInLoop() {
        assertEquals(11, Primes.nextPrime(9));
    }

    @Test
    public void testNextPrime_MultipleIterations() {
        assertTrue(Primes.isPrime(Primes.nextPrime(20)));
    }
}
// ```