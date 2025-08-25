package com.example.juniteg.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceNegativeTest {

    private final CalculatorService calculator = new CalculatorService();

    @Test
    @DisplayName("Expect wrong sum intentionally")
    public void testAddWrongExpectation1() {
        // Actual: 2 + 3 = 5, but expecting 6 → should fail
        assertEquals(6, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Fail by expecting wrong result for negative numbers")
    public void testAddWrongExpectation2() {
        // Actual: -2 + -3 = -5, but expecting -4 → should fail
        assertEquals(-4, calculator.add(-2, -3));
    }

    @Test
    @DisplayName("Fail by checking incorrect zero sum")
    public void testAddWrongExpectation3() {
        // Actual: 5 + -5 = 0, but expecting 1 → should fail
        assertEquals(1, calculator.add(5, -5));
    }

    @Test
    @DisplayName("Fail by giving wrong expectation for MAX_VALUE")
    public void testAddWrongExpectation4() {
        // Actual: Integer.MAX_VALUE + 0 = Integer.MAX_VALUE, but expecting 0 → should fail
        assertEquals(0, calculator.add(Integer.MAX_VALUE, 0));
    }

    @Test
    @DisplayName("Fail by forcing wrong overflow result")
    public void testAddWrongExpectation5() {
        // Actual overflow: Integer.MAX_VALUE + 1 = Integer.MIN_VALUE, but expecting Integer.MAX_VALUE → should fail
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 1));
    }
}
