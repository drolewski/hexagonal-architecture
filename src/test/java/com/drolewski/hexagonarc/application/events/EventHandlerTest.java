package com.drolewski.hexagonarc.application.events;

import com.drolewski.hexagonarc.application.events.orders.paid.PaidOrderEvent;
import com.drolewski.hexagonarc.application.events.orders.paid.PaidOrderEventHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventHandlerTest {

    @Mock
    private PaidOrderEventHandler paidOrderEventHandler;

    @InjectMocks
    private EventHandler uut;

    @Test
    void should_handle_paid_order_event() {
        // given
        final var paidOrderEvent = new PaidOrderEvent("orderId");
        doNothing().when(paidOrderEventHandler).handle(any());

        // when
        uut.handle(paidOrderEvent);

        // then
        verify(paidOrderEventHandler).handle(paidOrderEvent);
    }

    @Test
    void should_not_handle_paid_order_event() {
        // given
        final Event testEvent = new TestEvent();

        // when
        uut.handle(testEvent);

        // then
        verify(paidOrderEventHandler, never()).handle(any());
    }

    static class TestEvent extends Event {
        public TestEvent() {
            super(EventName.INVOICE_ISSUED);
        }
    }

}