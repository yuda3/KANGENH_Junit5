package com.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add() {
        assertEquals(2,calculator.add(1,1));
    }

    @Test
    void sub() {
        assertEquals(0,calculator.sub(1,1));
    }

    @Test
    void mul() {
        assertEquals(9,calculator.mul(3,3));
    }
    @Nested
    class DivTest {
        @Test
        void div() {
            assertEquals(10, calculator.div(100, 10));
        }

        @Test
        void divThrowException() {
            assertThrows(IllegalArgumentException.class, () -> calculator.div(4, 0));
        }

        @Test
        void testDivException2() {
            try {
                calculator.div(3, 0);
                fail();
            } catch (IllegalArgumentException e) {
                assertEquals("第二引数に0が指定されました", e.getMessage());

            }
        }
    }
}