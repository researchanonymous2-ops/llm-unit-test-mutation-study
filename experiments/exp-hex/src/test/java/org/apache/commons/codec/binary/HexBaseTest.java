package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PIT.
 * Objetivo exclusivo: executar linhas relevantes do método
 * encodeHex(byte[]) da classe Hex.
 */
public class HexBaseTest {

    @Test
    void testEncodeHexWithSingleByte() {
        byte[] input = { 0x0F };

        char[] result = Hex.encodeHex(input);

        assertNotNull(result);
        assertEquals(2, result.length);
    }

    @Test
    void testEncodeHexWithMultipleBytes() {
        byte[] input = { 0x00, 0x01, 0x0A };

        char[] result = Hex.encodeHex(input);

        assertNotNull(result);
        assertEquals(6, result.length);
    }
}

