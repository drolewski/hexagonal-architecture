package com.drolewski.hexagonarc.application.events.orders.paid;

import com.drolewski.hexagonarc.application.events.EventProducer;
import com.drolewski.hexagonarc.application.events.invoices.issued.InvoiceIssuedEvent;
import com.drolewski.hexagonarc.domain.model.aggregate.Invoice;
import com.drolewski.hexagonarc.domain.model.ports.InvoiceRepository;
import com.drolewski.hexagonarc.domain.model.ports.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaidOrderEventHandler {

    private final InvoiceService invoiceService;
    private final InvoiceRepository invoiceRepository;
    private final EventProducer eventProducer;

    public void handle(final PaidOrderEvent event) {
        final var invoice = this.invoiceService.create(event.getOrderId());
        invoiceRepository.save(invoice);
        eventProducer.send(new InvoiceIssuedEvent(invoice));
    }

}
