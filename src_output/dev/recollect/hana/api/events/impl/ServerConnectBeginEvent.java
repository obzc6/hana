/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_639;
import net.minecraft.class_642;

public class ServerConnectBeginEvent
extends Event {
    private final class_639 address;
    private final class_642 info;

    public ServerConnectBeginEvent(class_639 address, class_642 info) {
        super(Event.Stage.Pre);
        this.address = address;
        this.info = info;
    }

    public class_639 getAddress() {
        return this.address;
    }

    public class_642 getInfo() {
        return this.info;
    }
}
