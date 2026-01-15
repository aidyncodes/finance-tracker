package com.aidyn.financetracker.dto;

import java.math.BigDecimal;

public record CategoryTotal(String category, BigDecimal total) {}
    // select columns with category (param), count agg funct by amount

