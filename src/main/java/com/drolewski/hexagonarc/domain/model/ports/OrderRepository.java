package com.drolewski.hexagonarc.domain.model.ports;

import com.drolewski.hexagonarc.infrastructure.orders.Order;

public interface OrderRepository {
    Order get(final String orderId);
}
