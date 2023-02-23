package com.drolewski.hexagonarc.domain.model.aggregate;

import com.drolewski.hexagonarc.infrastructure.orders.Order;
import lombok.Getter;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
public class Invoice {
    private final String id;
    private final List<InvoiceItem> invoiceItems;
    private final Date date;
    private final Date dueDate;
    private final String from;
    private final String billTo;
    private final String shipTo;

    public Invoice(final Order order) {
        this.id = "FV/" + order.id();
        this.invoiceItems = Optional.ofNullable(order.orderItems())
                .orElse(Collections.emptyList())
                .stream().map(InvoiceItemAdapter::of)
                .toList();
        this.date = order.date();
        this.dueDate = order.dueDate();
        this.from = order.from();
        this.billTo = order.billTo();
        this.shipTo = order.shipTo();
    }

}
