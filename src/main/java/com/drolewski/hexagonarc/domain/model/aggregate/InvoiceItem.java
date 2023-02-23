package com.drolewski.hexagonarc.domain.model.aggregate;

import lombok.Builder;

import java.math.BigDecimal;

public record InvoiceItem(String description, BigDecimal quantity, BigDecimal unitPrice,
                          BigDecimal amount) {
    @Builder
    public InvoiceItem(final String description, final BigDecimal quantity, final BigDecimal unitPrice) {
        this(description, quantity, unitPrice, quantity.multiply(unitPrice));
    }

}
