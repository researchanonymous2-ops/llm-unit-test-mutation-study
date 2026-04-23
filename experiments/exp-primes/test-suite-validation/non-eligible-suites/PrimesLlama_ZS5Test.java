package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimesLlama_ZS5Test {

    @Test
    public void testNextPrime_NegativeNumber() {
        assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
    }

    @Test
    public void testNextPrime_Zero() {
        assertEquals(2, Primes.nextPrime(0));
    }

    @Test
    public void testNextPrime_One() {
        assertEquals(2, Primes.nextPrime(1));
    }

    @Test
    public void testNextPrime_Two() {
        assertEquals(2, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_PrimeNumber() {
        assertEquals(7, Primes.nextPrime(7));
    }

    @Test
    public void testNextPrime_NonPrimeNumber() {
        assertEquals(7, Primes.nextPrime(6));
    }

    @Test
    public void testNextPrime_NearPrimeNumber() {
        assertEquals(7, Primes.nextPrime(5));
    }

    @Test
    public void testNextPrime_MaxInt() {
        assertEquals(2147483647, Primes.nextPrime(2147483647));
    }
}
// ```