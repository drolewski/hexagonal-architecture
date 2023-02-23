package com.drolewski.hexagonarc.application.entrypoint;

import com.drolewski.hexagonarc.application.events.EventProducer;
import com.drolewski.hexagonarc.application.events.orders.paid.PaidOrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final EventProducer eventProducer;

    @PostMapping(value = "event")
    public void postEvent() {
        eventProducer.send(new PaidOrderEvent("paidOrderId"));
    }

}
