package com.drolewski.hexagonarc.application.events;

import com.drolewski.hexagonarc.application.events.orders.paid.PaidOrderEvent;
import com.drolewski.hexagonarc.application.events.orders.paid.PaidOrderEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.drolewski.hexagonarc.application.events.EventName.ORDER_PAID;

@Component
@RequiredArgsConstructor
public class EventHandler {

    private final PaidOrderEventHandler paidOrderEventHandler;

    public void handle(final Event event) {
        if (ORDER_PAID.equals(event.getName())) {
            paidOrderEventHandler.handle((PaidOrderEvent) event);
        }
    }

}
