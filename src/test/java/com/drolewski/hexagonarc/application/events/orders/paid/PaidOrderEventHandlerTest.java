package com.drolewski.hexagonarc.application.events.orders.paid;


import com.drolewski.hexagonarc.application.events.EventProducer;
import com.drolewski.hexagonarc.application.events.invoices.issued.InvoiceIssuedEvent;
import com.drolewski.hexagonarc.domain.model.aggregate.Invoice;
import com.drolewski.hexagonarc.domain.model.ports.InvoiceRepository;
import com.drolewski.hexagonarc.domain.model.ports.InvoiceService;
import com.drolewski.hexagonarc.infrastructure.orders.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaidOrderEventHandlerTest {

    @Mock
    private InvoiceService invoiceService;
    @Mock
    private InvoiceRepository invoiceRepository;
    @Mock
    private EventProducer eventProducer;
    @InjectMocks
    private PaidOrderEventHandler uut;

    @Test
    void should_handle_paid_order_event() {
        // given
        final var orderId = "orderId";
        final var invoice = new Invoice(Order.builder().build());
        when(invoiceService.create(anyString())).thenReturn(invoice);
        doNothing().when(invoiceRepository).save(any());
        doNothing().when(eventProducer).send(any());

        // when
        uut.handle(new PaidOrderEvent(orderId));

        // then
        verify(invoiceService).create(orderId);
        verify(invoiceRepository).save(invoice);
        verify(eventProducer).send(any());
    }

}