package com.drolewski.hexagonarc.application.events.orders.paid;

import com.drolewski.hexagonarc.application.events.Event;
import com.drolewski.hexagonarc.application.events.EventName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
public final class PaidOrderEvent extends Event implements Serializable {
    private String orderId;

    public PaidOrderEvent(final String orderId) {
        super(EventName.ORDER_PAID);
        this.orderId = orderId;
    }

}
