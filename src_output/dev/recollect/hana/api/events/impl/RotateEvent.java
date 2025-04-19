/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_243;

public class RotateEvent
extends Event {
    private float yaw;
    private float pitch;
    private boolean modified;
    private class_243 target;
    private boolean rotation;
    private float speed;
    public float priority = 0.0f;

    public RotateEvent(float yaw, float pitch) {
        super(Event.Stage.Pre);
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float yaw) {
        this.modified = true;
        this.yaw = yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setPitch(float pitch) {
        this.modified = true;
        this.pitch = pitch;
    }

    public boolean isModified() {
        return this.modified;
    }

    public void setRotation(float yaw, float pitch) {
        this.setYaw(yaw);
        this.setPitch(pitch);
    }

    public void setYawNoModify(float yaw) {
        this.yaw = yaw;
    }

    public void setPitchNoModify(float pitch) {
        this.pitch = pitch;
    }

    public void setTarget(class_243 target, float speed, float priority) {
        if (priority >= this.priority) {
            this.rotation = false;
            this.priority = priority;
            this.target = target;
            this.speed = speed;
        }
    }

    public class_243 getTarget() {
        return this.target;
    }

    public float getSpeed() {
        return this.speed;
    }

    public boolean getRotation() {
        return this.rotation;
    }
}
