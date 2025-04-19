/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_1657;

public class TotemEvent
extends Event {
    private final class_1657 player;

    public TotemEvent(class_1657 player) {
        super(Event.Stage.Post);
        this.player = player;
    }

    public class_1657 getPlayer() {
        return this.player;
    }
}
