/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_2338;

public class EventBreakBlock
extends Event {
    private class_2338 bp;

    public EventBreakBlock(class_2338 bp) {
        super(Event.Stage.Pre);
        this.bp = bp;
    }

    public class_2338 getPos() {
        return this.bp;
    }
}
