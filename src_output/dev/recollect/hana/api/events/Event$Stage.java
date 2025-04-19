/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events;

import dev.recollect.hana.api.events.Event;

public static final class Event.Stage
extends Enum<Event.Stage> {
    public static final /* enum */ Event.Stage Pre = new Event.Stage();
    public static final /* enum */ Event.Stage Post = new Event.Stage();
    private static final /* synthetic */ Event.Stage[] $VALUES;

    public static Event.Stage[] values() {
        return (Event.Stage[])$VALUES.clone();
    }

    public static Event.Stage valueOf(String name) {
        return Enum.valueOf(Event.Stage.class, name);
    }

    private static /* synthetic */ Event.Stage[] $values() {
        return new Event.Stage[]{Pre, Post};
    }

    static {
        $VALUES = Event.Stage.$values();
    }
}
