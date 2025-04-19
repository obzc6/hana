/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_1657;

public class TravelEvent
extends Event {
    private final class_1657 entity;

    public TravelEvent(Event.Stage stage, class_1657 entity) {
        super(stage);
        this.entity = entity;
    }

    public class_1657 getEntity() {
        return this.entity;
    }
}
