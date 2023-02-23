package com.drolewski.hexagonarc.infrastructure.orders;

import lombok.Builder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record Order(UUID id,
                    List<OrderItem> orderItems,
                    Date date,
                    Date dueDate,
                    String from,
                    String billTo,
                    String shipTo,
                    OrderStatus status) {
    // IntelliJ bug workaround: https://stackoverflow.com/a/70678461
    @Builder
    public Order {
    }
}
