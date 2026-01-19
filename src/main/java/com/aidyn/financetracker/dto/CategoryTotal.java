package com.aidyn.financetracker.dto;

import java.math.BigDecimal;

public record CategoryTotal(String category, BigDecimal total) {
    // records fields are final because it serves as a data carrier
    // record automatically creates constructor ....

}

