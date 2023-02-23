package com.drolewski.hexagonarc.application.events;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.drolewski.hexagonarc.application.events.EventConsumer.EVENTS_TOPIC;

@Component
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, Event> template;

    public void send(final Event event) {
        System.out.println("produce event=" + event);
        this.template.send(EVENTS_TOPIC, event);
    }

}
