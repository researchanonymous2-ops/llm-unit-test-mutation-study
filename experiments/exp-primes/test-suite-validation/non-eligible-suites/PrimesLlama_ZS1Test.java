package org.apache.commons.math3.primes;

// ```java
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesLlama_ZS1Test {

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
    public void testNextPrime_EvenNumber() {
        assertEquals(3, Primes.nextPrime(2));
    }

    @Test
    public void testNextPrime_MultipleOfThree() {
        assertEquals(5, Primes.nextPrime(4));
    }
}
// ```