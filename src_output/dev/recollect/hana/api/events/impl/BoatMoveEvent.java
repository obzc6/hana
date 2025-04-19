/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1690
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_1690;

public class BoatMoveEvent
extends Event {
    private final class_1690 boat;

    public BoatMoveEvent(class_1690 boat) {
        super(Event.Stage.Pre);
        this.boat = boat;
    }

    public class_1690 getBoat() {
        return this.boat;
    }
}
