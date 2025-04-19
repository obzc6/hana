/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_1297;

public class EntitySpawnEvent
extends Event {
    private final class_1297 entity;

    public EntitySpawnEvent(class_1297 entity) {
        super(Event.Stage.Pre);
        this.entity = entity;
    }

    public class_1297 getEntity() {
        return this.entity;
    }
}
