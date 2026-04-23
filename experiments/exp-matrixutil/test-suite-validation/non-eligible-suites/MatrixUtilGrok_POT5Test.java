package com.thealgorithms.maths;

// ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;
import com.thealgorithms.maths.MatrixUtil;

public class MatrixUtilGrok_POT5Test {

    @Test
    public void testMultiply_IncompatibleDimensions() {
        // Arrange
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.ZERO, BigDecimal.ONE}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE},
            {BigDecimal.ZERO}
        };

        // Act
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMultiply_SizeOne() {
        // Arrange
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE},
            {BigDecimal.TEN}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN}
        };

        // Act
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    public void testMultiply_FullIteration() {
        // Arrange
        BigDecimal[][] matrix1 = {
            {BigDecimal.ONE, BigDecimal.TEN},
            {BigDecimal.ZERO, BigDecimal.ONE}
        };
        BigDecimal[][] matrix2 = {
            {BigDecimal.ONE, BigDecimal.ZERO},
            {BigDecimal.TEN, BigDecimal.ONE}
        };

        // Act
        Optional<BigDecimal[][]> result = MatrixUtil.multiply(matrix1, matrix2);

        // Assert
        assertTrue(result.isPresent());
    }
}
// ```