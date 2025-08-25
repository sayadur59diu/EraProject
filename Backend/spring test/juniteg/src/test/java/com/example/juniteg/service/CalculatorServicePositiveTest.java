package com.example.juniteg.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServicePositiveTest {

    private final CalculatorService calculator = new CalculatorService();

    @Test
    @DisplayName("Add two positive numbers")
    public void testAddPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Add positive and negative number")
    public void testAddPositiveAndNegative() {
        assertEquals(-1, calculator.add(2, -3));
    }

    @Test
    @DisplayName("Add two negative numbers")
    public void testAddNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    @DisplayName("Add zero and positive number")
    public void testAddZeroAndPositive() {
        assertEquals(7, calculator.add(0, 7));
    }

    @Test
    @DisplayName("Add zero and negative number")
    public void testAddZeroAndNegative() {
        assertEquals(-8, calculator.add(0, -8));
    }

    @Test
    @DisplayName("Add large positive numbers")
    public void testAddLargePositiveNumbers() {
        assertEquals(2_000_000_000, calculator.add(1_000_000_000, 1_000_000_000));
    }

    @Test
    @DisplayName("Add large negative numbers")
    public void testAddLargeNegativeNumbers() {
        assertEquals(-2_000_000_000, calculator.add(-1_000_000_000, -1_000_000_000));
    }

    @Test
    @DisplayName("Add number to itself")
    public void testAddSameNumber() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    @DisplayName("Add opposite numbers")
    public void testAddOppositeNumbers() {
        assertEquals(0, calculator.add(5, -5));
    }

    @Test
    @DisplayName("Add with Integer.MAX_VALUE and 0")
    public void testAddMaxValueAndZero() {
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 0));
    }
}
