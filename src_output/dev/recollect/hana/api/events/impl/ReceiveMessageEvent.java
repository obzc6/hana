/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class ReceiveMessageEvent
extends Event {
    public String message;

    public ReceiveMessageEvent(String message) {
        super(Event.Stage.Pre);
        this.message = message;
    }

    public String getString() {
        return this.message;
    }
}
