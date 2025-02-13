package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtraTest extends AbstractParent {

            private static Calculator calculator = new Calculator();
            private final double DELTA = 0.001;

            @BeforeAll
            public static void testPowerOn() {
                System.out.println("@BeforeAll Power ON (before the first test)");
                calculator.powerOn();
            }

            @AfterAll
            public static void testPowerOff() {
                System.out.println("@AfterAll Power OFF (all tests run).");
                calculator.powerOff();
                calculator = null;
            }

            @BeforeEach
            public void testReset() {
                System.out.println("  Reset calculator.");
                calculator.reset();
                assertEquals(0, calculator.getResult(), "Reset failed");
            }

            @ParameterizedTest
            @ValueSource(doubles = {2.0, 4.0, 5.0})
            public void testSquare(double number) {
                calculator.square(number);
                assertEquals(number * number, calculator.getResult(), DELTA, "Squaring " + number + " is incorrect");
            }

            @ParameterizedTest
            @ValueSource(doubles = {2.0, 4.0, 9.0, 16.0})
            public void testSquareRoot(double number) {
                calculator.squareRoot(number);
                assertEquals(Math.sqrt(number), calculator.getResult(), DELTA, "Square root of " + number + " is incorrect");
            }

            @Test
            @DisplayName("Test negative square root")
            public void testSquareRootNegative() {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-4.0));
                assertEquals("Cannot take square root of a negative number", exception.getMessage());
            }
        }