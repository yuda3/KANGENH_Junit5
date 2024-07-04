package com.group.mokito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxAmountServiceTest {

    @Mock
    private TaxService service;

    @InjectMocks
    private TaxAmountService taxAmountService;

    @Test
    @DisplayName("8%で端数切捨て")
    public void testTaxAmountService() {
        when(service.getTaxRate(any())).thenReturn(BigDecimal.valueOf(8));
        var taxAmount1 = taxAmountService.getTaxAmount(106, LocalDate.of(2019, 9 ,30));
        assertEquals(8, taxAmount1);
    }

    @Test
    @DisplayName("8%で端数切上げ")
    public void testTaxAmountService2() {
//        doReturn(BigDecimal.valueOf(8)).when(service).getTaxRate(any());
    }

}