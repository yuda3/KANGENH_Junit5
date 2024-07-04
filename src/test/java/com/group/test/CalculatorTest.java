package com.group.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    void taxPriceThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.taxPrice(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.taxPrice(-100));
    }
    @Test
    void taxPrice() {
        assertEquals(110, calculator.taxPrice(100));
    }

    @Test
    void testTaxPrice() {
    }
}