/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class UpdateWalkingEvent
extends Event {
    private boolean cancelRotate = false;

    public UpdateWalkingEvent(Event.Stage stage) {
        super(stage);
    }

    public void cancelRotate() {
        this.cancelRotate = true;
    }

    public void setCancelRotate(boolean cancelRotate) {
        this.cancelRotate = cancelRotate;
    }

    public boolean isCancelRotate() {
        return this.cancelRotate;
    }
}
