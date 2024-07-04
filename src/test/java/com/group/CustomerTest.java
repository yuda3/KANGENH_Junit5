package com.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomerTest {

    Customer customer;

    @BeforeEach
    void setUp() throws Exception {
        customer = new Customer();
    }

    @ParameterizedTest
    @CsvSource({
            "20, '東京都', 1, true",
            "20, '東京都', 0, false",
            "20, '千葉県', 1, false",
            "19, '東京都', 1, false"
    })
    void testCheckBonus(int age, String address, int count, boolean expected) {
        boolean actual = customer.checkBonus(age,address,count);
        assertEquals(expected, actual);


    }

}