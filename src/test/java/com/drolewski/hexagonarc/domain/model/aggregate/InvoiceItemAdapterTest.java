package com.drolewski.hexagonarc.domain.model.aggregate;

import com.drolewski.hexagonarc.infrastructure.orders.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class InvoiceItemAdapterTest {

    public static final String DESCRIPTION = "description";

    @Test
    void should_create_invoice_item() {
        // given
        final var orderItem = OrderItem.builder()
                .description(DESCRIPTION)
                .unitPrice(BigDecimal.ONE)
                .quantity(BigDecimal.TEN)
                .build();

        // when
        final var invoiceItem = InvoiceItemAdapter.of(orderItem);

        // then
        assertAll(() -> assertThat(invoiceItem.description()).isEqualTo(DESCRIPTION),
                () -> assertThat(invoiceItem.unitPrice()).isEqualTo(BigDecimal.ONE),
                () -> assertThat(invoiceItem.quantity()).isEqualTo(BigDecimal.TEN),
                () -> assertThat(invoiceItem.amount()).isEqualTo(BigDecimal.TEN));
    }

}