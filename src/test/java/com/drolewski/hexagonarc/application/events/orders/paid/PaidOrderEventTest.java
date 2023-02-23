package com.drolewski.hexagonarc.application.events.orders.paid;

import com.drolewski.hexagonarc.application.events.EventName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PaidOrderEventTest {

    @Test
    void should_construct_paid_order_event() {
        // given
        final var id = UUID.randomUUID().toString();

        // when
        final var paidOrderEvent = new PaidOrderEvent(id);

        // then
        assertThat(paidOrderEvent)
                .extracting("orderId", "name")
                .containsExactly(id, EventName.ORDER_PAID);
    }

}