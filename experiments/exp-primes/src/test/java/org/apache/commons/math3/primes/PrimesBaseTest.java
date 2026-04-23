package org.apache.commons.math3.primes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimesBaseTest {

    @Test
    void testNextPrime_ActivationForMutationInstrumentation() {
        assertEquals(7, Primes.nextPrime(6));     
        assertEquals(11, Primes.nextPrime(8));    
        assertEquals(23, Primes.nextPrime(20));   
    }
}

