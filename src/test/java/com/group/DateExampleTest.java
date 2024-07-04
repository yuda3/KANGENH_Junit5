package com.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateExampleTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getDate() {
    }

    @Test
    void setDate() {
    }

    @Test
    void getMessage() {
    }

    @Test
    void setMessage() {
        final LocalDateTime current = LocalDateTime.now();

        DateExample sut = new DateExample(){

            public LocalDateTime newDate(){
                return current;
            }
        };

        sut.setMessage();
        assertEquals("現在時刻:" + current, sut.getMessage());

    }

    @Test
    void testSetMessage() {
    }
}