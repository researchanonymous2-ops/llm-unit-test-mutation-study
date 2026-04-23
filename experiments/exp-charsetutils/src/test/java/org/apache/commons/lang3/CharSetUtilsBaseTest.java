package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PIT.
 * Objetivo exclusivo: executar linhas relevantes do método
 * squeeze(String, String...) da classe CharSetUtils.
 */
public class CharSetUtilsBaseTest {

    @Test
    void testSqueezeWithNullString() {
        // ativa o retorno antecipado: StringUtils.isEmpty(str)
        String result = CharSetUtils.squeeze(null, "a-z");
        assertNull(result);
    }

    @Test
    void testSqueezeWithEmptyString() {
        // ativa o retorno antecipado: StringUtils.isEmpty(str)
        String result = CharSetUtils.squeeze("", "a-z");
        assertEquals("", result);
    }

    @Test
    void testSqueezeWithNullSet() {
        // ativa o retorno antecipado: deepEmpty(set)
        String result = CharSetUtils.squeeze("hello", (String[]) null);
        assertEquals("hello", result);
    }

    @Test
    void testSqueezeWithRepeatedCharactersInSet() {
        // ativa o laço principal e a condição:
        // ch == lastChar && i != 0 && chars.contains(ch)
        String result = CharSetUtils.squeeze("hello", "k-p");
        assertEquals("helo", result);
    }

    @Test
    void testSqueezeWithoutRepeatedCharactersInSet() {
        // ativa o caminho onde chars.contains(ch) é falso
        String result = CharSetUtils.squeeze("hello", "a-e");
        assertEquals("hello", result);
    }
}

