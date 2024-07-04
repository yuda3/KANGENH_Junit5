package com.group.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BusinessDayServiceTest {
    BusinessDayService businessDayService;
    @BeforeEach
    void setUp() {
        businessDayService = new BusinessDayService();
    }

    @Test
    void isBusinessDay() {
        assertTrue(businessDayService.isBusinessDay(LocalDate.of(2022,10,20)));
    }

    @Test
    void testHolidayIsNotBusinessDay() {
        assertFalse(businessDayService.isBusinessDay(LocalDate.of(2022,11,3)));
    }

    @Test
    void testSaturdayIsNotBusinessDay() {
        assertFalse(businessDayService.isBusinessDay(LocalDate.of(2022,12,17)));
    }

    @Test
    void testSundayIsNotBusinessDay() {
        assertFalse(businessDayService.isBusinessDay(LocalDate.of(2022,12,25)));
    }

    @Test
    void testGetNextBusinessDayIsNull() {
        assertNull(businessDayService.getNextBusinessDay(LocalDate.of(2022,8,11), 5));
    }
    @Test
    void testGetNextBusinessDay() {
        assertNotNull(businessDayService.getNextBusinessDay(LocalDate.of(2022,9,26), 5));
    }

    @Test
    void testGetBusinessDayArray() {

        LocalDate[] result = new LocalDate[]{LocalDate.of(2022,10,7), LocalDate.of(2022,10,11), LocalDate.of(2022,10,12)};
        assertArrayEquals(result,businessDayService.getBusinessDayArray(LocalDate.of(2022,10,7),5));
    }

    @Test
    void testGetBusinessDayList() {
        LocalDate[] result = new LocalDate[]{LocalDate.of(2022,10,7), LocalDate.of(2022,10,11), LocalDate.of(2022,10,12)};
        assertIterableEquals(Arrays.asList(result),businessDayService.getBusinessDayList(LocalDate.of(2022,10,7),5));
    }
}