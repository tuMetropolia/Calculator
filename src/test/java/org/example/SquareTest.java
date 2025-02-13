package org.example;
//Kim Tran-Do
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This uses the ParameterizedTest annotation
// Parameter pairs in the table (comma separated values)

public class SquareTest {

    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @ParameterizedTest(name = "The square of {0} is {1}")
    @CsvSource({ "0, 0", "1, 1", "2, 4", "4, 16", "5, 25", "6, 36" })
    public void testSquare(int number, int result) {
        calculator.square(number);
        assertEquals(result, calculator.getResult(), "Squaring is not working correctly");
    }
}