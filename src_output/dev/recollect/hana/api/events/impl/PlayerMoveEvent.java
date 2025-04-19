/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_243;

public class PlayerMoveEvent
extends Event {
    public class_243 movement;
    public float yaw;

    public PlayerMoveEvent(Event.Stage stage, class_243 movement, float yaw) {
        super(stage);
        this.movement = movement;
        this.yaw = yaw;
    }

    public class_243 getMovement() {
        return this.movement;
    }

    public void setMovement(class_243 movement) {
        this.movement = movement;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }
}
