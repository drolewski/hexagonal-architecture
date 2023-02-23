package com.drolewski.hexagonarc.domain.model.ports;

import com.drolewski.hexagonarc.domain.model.aggregate.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceService {

    private final OrderRepository orderRepository;

    public Invoice create(final String paidOrderId) {
        final var order = orderRepository.get(paidOrderId);
        return new Invoice(order);
    }

}
