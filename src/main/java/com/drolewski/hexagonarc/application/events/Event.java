package com.drolewski.hexagonarc.application.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final Date created = new Date();
    public EventName name;
}
