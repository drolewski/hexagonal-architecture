package com.drolewski.hexagonarc.application.events;

import lombok.Getter;

public enum EventName {

    ORDER_PAID("OrderPaid"),
    INVOICE_ISSUED("InvoiceIssued");

    @Getter
    private final String name;

    EventName(final String name) {
        this.name = name;
    }

}
