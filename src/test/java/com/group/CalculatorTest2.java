package com.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class CalculatorTest2 {

    Calculator2 sut;

    @BeforeEach
    void setUp() {
        sut =  new Calculator2();
    }

    @Test
    void addTest(){
        assertEquals(5, sut.add(2,3));
    }
    @Test
    void addTest2(){
        assertEquals(4, sut.add(1,3));
    }
}