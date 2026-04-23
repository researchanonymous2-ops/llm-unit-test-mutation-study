package org.apache.commons.codec.binary;

// ```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryCodecQwen_POT4Test {

    @Test
    @DisplayName("testToAsciiBytes_NullInput_ReturnsEmptyArray")
    void testToAsciiBytes_NullInput_ReturnsEmptyArray() {
        byte[] result = BinaryCodec.toAsciiBytes(null);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("testToAsciiBytes_EmptyInput_ReturnsEmptyArray")
    void testToAsciiBytes_EmptyInput_ReturnsEmptyArray() {
        byte[] input = {};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("testToAsciiBytes_SingleByteZero_ReturnsEightZeros")
    void testToAsciiBytes_SingleByteZero_ReturnsEightZeros() {
        byte[] input = {0};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(8, result.length);
        
        for (int i = 0; i < result.length; i++) {
            assertEquals('0', result[i]);
        }
    }

    @Test
    @DisplayName("testToAsciiBytes_SingleByteMaxValue_ReturnsEightOnes")
    void testToAsciiBytes_SingleByteMaxValue_ReturnsEightOnes() {
        byte[] input = {(byte) 0xFF}; // All bits set to 1
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(8, result.length);
        
        for (int i = 0; i < result.length; i++) {
            assertEquals('1', result[i]);
        }
    }

    @Test
    @DisplayName("testToAsciiBytes_SingleByteMixedBits")
    void testToAsciiBytes_SingleByteMixedBits() {
        byte[] input = {(byte) 0b10101010};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(8, result.length);
        
        // Expected: "10101010" but in reverse order due to algorithm
        // The algorithm processes bits from least significant to most significant
        // So the output will be "01010101" in reverse indexing
        assertEquals('1', result[7]); // bit 0
        assertEquals('0', result[6]); // bit 1
        assertEquals('1', result[5]); // bit 2
        assertEquals('0', result[4]); // bit 3
        assertEquals('1', result[3]); // bit 4
        assertEquals('0', result[2]); // bit 5
        assertEquals('1', result[1]); // bit 6
        assertEquals('0', result[0]); // bit 7
    }

    @Test
    @DisplayName("testToAsciiBytes_MultipleBytes")
    void testToAsciiBytes_MultipleBytes() {
        byte[] input = {(byte) 0b10000000, (byte) 0b00000001};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(16, result.length);
        
        // First byte: 10000000 -> should produce "10000000" in some order
        // Second byte: 00000001 -> should produce "00000001" in some order
        // Due to algorithm's reverse processing, check expected pattern
        assertEquals('1', result[7]);   // bit 0 of first byte
        assertEquals('0', result[6]);   // bit 1 of first byte
        assertEquals('0', result[5]);   // bit 2 of first byte
        assertEquals('0', result[4]);   // bit 3 of first byte
        assertEquals('0', result[3]);   // bit 4 of first byte
        assertEquals('0', result[2]);   // bit 5 of first byte
        assertEquals('0', result[1]);   // bit 6 of first byte
        assertEquals('0', result[0]);   // bit 7 of first byte
        
        assertEquals('0', result[15]);  // bit 0 of second byte
        assertEquals('0', result[14]);  // bit 1 of second byte
        assertEquals('0', result[13]);  // bit 2 of second byte
        assertEquals('0', result[12]);  // bit 3 of second byte
        assertEquals('0', result[11]);  // bit 4 of second byte
        assertEquals('0', result[10]);  // bit 5 of second byte
        assertEquals('0', result[9]);   // bit 6 of second byte
        assertEquals('1', result[8]);   // bit 7 of second byte
    }

    @Test
    @DisplayName("testToAsciiBytes_ZeroAndOneBytes")
    void testToAsciiBytes_ZeroAndOneBytes() {
        byte[] input = {0, 1};
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(16, result.length);
        
        // First byte (0): all zeros
        for (int i = 0; i < 8; i++) {
            assertEquals('0', result[i]);
        }
        
        // Second byte (1): only LSB set
        assertEquals('1', result[15]); // LSB of second byte
        for (int i = 8; i < 15; i++) {
            assertEquals('0', result[i]);
        }
    }

    @Test
    @DisplayName("testToAsciiBytes_NegativeByte")
    void testToAsciiBytes_NegativeByte() {
        byte[] input = {(byte) -1}; // Same as 0xFF, all bits set
        byte[] result = BinaryCodec.toAsciiBytes(input);
        assertEquals(8, result.length);
        
        for (int i = 0; i < result.length; i++) {
            assertEquals('1', result[i]);
        }
    }
}
// ```