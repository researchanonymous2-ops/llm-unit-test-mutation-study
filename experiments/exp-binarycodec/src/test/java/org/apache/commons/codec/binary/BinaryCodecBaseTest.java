package org.apache.commons.codec.binary;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Suíte base de testes para ativação de mutantes com PIT.
 *
 * Objetivo exclusivo: executar caminhos relevantes do método
 * toAsciiBytes(byte[] raw) da classe BinaryCodec.
 *
 * Não realiza verificação semântica detalhada, pois não tem como
 * objetivo matar mutantes.
 */
public class BinaryCodecBaseTest {

    @Test
    void testToAsciiBytesWithNullInput() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertNotNull(result);
    }

    @Test
    void testToAsciiBytesWithEmptyArray() {
        byte[] input = {};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
    }

    @Test
    void testToAsciiBytesWithSingleByte() {
        byte[] input = { 0x01 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
    }

    @Test
    void testToAsciiBytesWithMultipleBytes() {
        byte[] input = { 0x0F, (byte) 0xA5 };
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
    }
}

