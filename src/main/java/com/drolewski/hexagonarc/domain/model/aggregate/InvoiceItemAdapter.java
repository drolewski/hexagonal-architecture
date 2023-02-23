package com.drolewski.hexagonarc.domain.model.aggregate;


import com.drolewski.hexagonarc.infrastructure.orders.OrderItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class InvoiceItemAdapter {

    static InvoiceItem of(final OrderItem orderItem) {
        return InvoiceItem.builder()
                .description(orderItem.description())
                .unitPrice(orderItem.unitPrice())
                .quantity(orderItem.quantity())
                .build();
    }

}
