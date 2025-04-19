/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class TimerEvent
extends Event {
    private float timer = 1.0f;
    private boolean modified;

    public TimerEvent() {
        super(Event.Stage.Pre);
    }

    public float get() {
        return this.timer;
    }

    public void set(float timer) {
        this.modified = true;
        this.timer = timer;
    }

    public boolean isModified() {
        return this.modified;
    }
}
