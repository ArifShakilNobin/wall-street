package com.wallstreet.ecommerce.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
public class SaleSummary {
    // Getters and setters
    private LocalDate date;
    private BigDecimal totalAmount;

    public SaleSummary(LocalDate date, BigDecimal totalAmount) {
        this.date = date;
        this.totalAmount = totalAmount;
    }

}