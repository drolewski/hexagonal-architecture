package com.drolewski.hexagonarc.infrastructure.orders;

import lombok.Builder;

import java.math.BigDecimal;

public record OrderItem(String description, BigDecimal quantity, BigDecimal unitPrice) {
    // IntelliJ bug workaround: https://stackoverflow.com/a/70678461
    @Builder
    public OrderItem {

    }
}
