/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_3191
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_2338;
import net.minecraft.class_3191;

public class WorldBreakEvent
extends Event {
    private final class_3191 blockBreakingInfo;

    public WorldBreakEvent(class_3191 pos) {
        super(Event.Stage.Pre);
        this.blockBreakingInfo = pos;
    }

    public class_2338 getPos() {
        return this.blockBreakingInfo.method_13991();
    }

    public int getId() {
        return this.blockBreakingInfo.method_34868();
    }
}
