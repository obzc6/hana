/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class SendMessageEvent
extends Event {
    public String message;
    public final String defaultMessage;

    public SendMessageEvent(String message) {
        super(Event.Stage.Pre);
        this.defaultMessage = message;
        this.message = message;
    }
}
