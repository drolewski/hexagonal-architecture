package com.drolewski.hexagonarc.application.events.invoices.issued;

import com.drolewski.hexagonarc.domain.model.aggregate.Invoice;
import com.drolewski.hexagonarc.application.events.EventName;
import com.drolewski.hexagonarc.infrastructure.orders.Order;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InvoiceIssuedEventTest {

    @Test
    void should_construct_invoice_issued_event() {
        // given
        final var id = UUID.randomUUID();
        final var invoice = new Invoice(Order.builder().id(id).build());

        // when
        final var invoiceIssuedEvent = new InvoiceIssuedEvent(invoice);

        // then
        assertThat(invoiceIssuedEvent)
                .extracting("invoiceId", "name")
                .containsExactly("FV/" + id, EventName.INVOICE_ISSUED);
    }

}