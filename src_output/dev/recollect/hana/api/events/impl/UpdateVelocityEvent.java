/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_243;

public class UpdateVelocityEvent
extends Event {
    class_243 movementInput;
    float speed;
    float yaw;
    class_243 velocity;

    public UpdateVelocityEvent(class_243 movementInput, float speed, float yaw, class_243 velocity) {
        super(Event.Stage.Pre);
        this.movementInput = movementInput;
        this.speed = speed;
        this.yaw = yaw;
        this.velocity = velocity;
    }

    public class_243 getMovementInput() {
        return this.movementInput;
    }

    public float getSpeed() {
        return this.speed;
    }

    public class_243 getVelocity() {
        return this.velocity;
    }

    public void setVelocity(class_243 velocity) {
        this.velocity = velocity;
    }
}
