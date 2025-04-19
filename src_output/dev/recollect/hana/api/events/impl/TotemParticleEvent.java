/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import java.awt.Color;

public class TotemParticleEvent
extends Event {
    public double velocityX;
    public double velocityY;
    public double velocityZ;
    public Color color;

    public TotemParticleEvent(double velocityX, double velocityY, double velocityZ) {
        super(Event.Stage.Pre);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }
}
