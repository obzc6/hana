/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_2338;
import net.minecraft.class_2680;

public class EventCollision
extends Event {
    private class_2680 bs;
    private class_2338 bp;

    public EventCollision(class_2680 bs, class_2338 bp) {
        super(Event.Stage.Pre);
        this.bs = bs;
        this.bp = bp;
    }

    public class_2680 getState() {
        return this.bs;
    }

    public class_2338 getPos() {
        return this.bp;
    }

    public void setState(class_2680 bs) {
        this.bs = bs;
    }
}
