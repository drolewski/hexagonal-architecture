package com.drolewski.hexagonarc.application.events;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventConsumer {

    public static final String EVENTS_TOPIC = "events";
    private final EventHandler eventHandler;

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(EVENTS_TOPIC)
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(groupId = "groupId", topics = EVENTS_TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void listen(final Event event) {
        System.out.println("consume event=" + event);
        eventHandler.handle(event);
    }

}
