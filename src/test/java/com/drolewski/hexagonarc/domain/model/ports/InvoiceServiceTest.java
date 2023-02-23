package com.drolewski.hexagonarc.domain.model.ports;

import com.drolewski.hexagonarc.domain.model.aggregate.InvoiceItem;
import com.drolewski.hexagonarc.infrastructure.orders.Order;
import com.drolewski.hexagonarc.infrastructure.orders.OrderItem;
import com.drolewski.hexagonarc.infrastructure.orders.OrderStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceTest {

    private static final String BILL_TO = "Bill To";
    private static final String SHIP_TO = "Ship To";
    private static final String FROM = "From";
    private static final String DESCRIPTION = "description";
    private static final UUID ID = UUID.randomUUID();
    private static final Date DATE = new Date();

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private InvoiceService uut;

    @Test
    void should_create_invoice() {
        // given
        final var paidOrderId = "paidOrderId";
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
        when(orderRepository.get(anyString())).thenReturn(order);

        // when
        final var invoice = uut.create(paidOrderId);

        // then
        assertThat(invoice).extracting("id", "invoiceItems", "date", "dueDate", "from", "billTo", "shipTo")
                .containsExactly("FV/" + ID, Collections.singletonList(InvoiceItem.builder()
                        .description(DESCRIPTION)
                        .unitPrice(BigDecimal.TEN)
                        .quantity(BigDecimal.ONE)
                        .build()), DATE, DATE, FROM, BILL_TO, SHIP_TO);
    }


}