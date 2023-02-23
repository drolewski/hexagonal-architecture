package com.drolewski.hexagonarc.domain.model.aggregate;

import com.drolewski.hexagonarc.infrastructure.orders.Order;
import com.drolewski.hexagonarc.infrastructure.orders.OrderItem;
import com.drolewski.hexagonarc.infrastructure.orders.OrderStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class InvoiceTest {

    private static final String BILL_TO = "Bill To";
    private static final String SHIP_TO = "Ship To";
    private static final String FROM = "From";
    private static final String DESCRIPTION = "description";
    private static final UUID ID = UUID.randomUUID();
    private static final Date DATE = new Date();

    @Test
    void should_create_invoice() {
        // given
        final var order = Order.builder()
                .id(ID)
                .date(DATE)
                .dueDate(DATE)
                .billTo(BILL_TO)
                .shipTo(SHIP_TO)
                .from(FROM)
                .status(OrderStatus.PAID)
                .orderItems(Collections.singletonList(OrderItem.builder()
                        .description(DESCRIPTION)
                        .quantity(BigDecimal.ONE)
                        .unitPrice(BigDecimal.TEN).build()))
                .build();

        // when
        final var invoice = new Invoice(order);

        // then
        assertThat(invoice).extracting("id", "invoiceItems", "date", "dueDate", "from", "billTo", "shipTo")
                .containsExactly("FV/" + ID, Collections.singletonList(InvoiceItem.builder()
                        .description(DESCRIPTION)
                        .unitPrice(BigDecimal.TEN)
                        .quantity(BigDecimal.ONE)
                        .build()), DATE, DATE, FROM, BILL_TO, SHIP_TO);
    }

    @Test
    void should_create_invoice_without_items() {
        final var order = Order.builder()
                .id(ID)
                .date(DATE)
                .dueDate(DATE)
                .billTo(BILL_TO)
                .shipTo(SHIP_TO)
                .from(FROM)
                .status(OrderStatus.PAID)
                .orderItems(Collections.emptyList())
                .build();

        // when
        final var invoice = new Invoice(order);

        // then
        assertThat(invoice).extracting("id", "invoiceItems", "date", "dueDate", "from", "billTo", "shipTo")
                .containsExactly("FV/" + ID, Collections.emptyList(), DATE, DATE, FROM, BILL_TO, SHIP_TO);
    }

}