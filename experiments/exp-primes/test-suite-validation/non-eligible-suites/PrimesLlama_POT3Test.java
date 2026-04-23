package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesLlama_POT3Test {

    @Test
    public void testNextPrime_Negative() {
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
    public void testNextPrime_Prime() {
        assertEquals(7, Primes.nextPrime(7));
    }

    @Test
    public void testNextPrime_MultipleOfThreePlusZero() {
        assertEquals(7, Primes.nextPrime(6));
    }

    @Test
    public void testNextPrime_MultipleOfThreePlusOne() {
        assertEquals(7, Primes.nextPrime(4));
    }

    @Test
    public void testNextPrime_MultipleOfThreePlusTwo() {
        assertEquals(7, Primes.nextPrime(5));
    }

    @Test
    public void testNextPrime_FirstPrimeInLoop() {
        assertEquals(11, Primes.nextPrime(8));
    }

    @Test
    public void testNextPrime_SecondPrimeInLoop() {
        assertEquals(11, Primes.nextPrime(9));
    }

    @Test
    public void testNextPrime_MultipleIterations() {
        assertEquals(23, Primes.nextPrime(20));
    }
}
// ```