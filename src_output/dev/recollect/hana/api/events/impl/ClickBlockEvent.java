/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_2338;

public class ClickBlockEvent
extends Event {
    private final class_2338 pos;

    public ClickBlockEvent(class_2338 pos) {
        super(Event.Stage.Pre);
        this.pos = pos;
    }

    public class_2338 getBlockPos() {
        return this.pos;
    }
}
