/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class EventPostSync
extends Event {
    public EventPostSync() {
        super(Event.Stage.Pre);
    }
}
