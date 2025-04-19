/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;

public class JumpEvent
extends Event {
    private double yaw;

    public JumpEvent(Event.Stage stage) {
        super(stage);
    }

    public double getMotionY() {
        return this.yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }
}
