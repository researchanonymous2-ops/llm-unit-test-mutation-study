package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PITest.
 * Objetivo exclusivo: executar linhas relevantes do método
 * surfaceAreaCone(double, double) da classe Area.
 */
public class AreaBaseTest {

    @Test
    void testSurfaceAreaConeWithValidRadiusAndHeight() {
        // ativa o caminho principal de cálculo
        double result = Area.surfaceAreaCone(3.0, 4.0);
        // valor esperado: π * r * (r + sqrt(h^2 + r^2))
        assertEquals(Math.PI * 3.0 * (3.0 + 5.0), result);
    }

    @Test
    void testSurfaceAreaConeWithRadiusZeroThrowsException() {
        // ativa a verificação de raio inválido
        assertThrows(IllegalArgumentException.class, () ->
            Area.surfaceAreaCone(0.0, 5.0)
        );
    }

    @Test
    void testSurfaceAreaConeWithNegativeHeightThrowsException() {
        // ativa a verificação de altura inválida
        assertThrows(IllegalArgumentException.class, () ->
            Area.surfaceAreaCone(3.0, -1.0)
        );
    }
}

