package com.drolewski.hexagonarc.infrastructure.orders;

import com.drolewski.hexagonarc.domain.model.ports.OrderRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class MongoOrderRepository implements OrderRepository {
    @Override
    public Order get(final String orderId) {
        // Here should be order logic of MongoOrderRepository

        // Mocked implementation
        System.out.println("get order from database");
        return Order.builder()
                .id(UUID.randomUUID())
                .date(new Date())
                .orderItems(List.of(OrderItem.builder()
                        .description("Test1")
                        .quantity(BigDecimal.ONE)
                        .unitPrice(BigDecimal.TEN)
                        .build()))
                .dueDate(new Date())
                .from("From")
                .billTo("Bill To")
                .shipTo("Ship To")
                .status(OrderStatus.PAID)
                .build();
    }
}
