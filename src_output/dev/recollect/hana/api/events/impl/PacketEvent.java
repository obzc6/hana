/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_2596;

public class PacketEvent
extends Event {
    public final class_2596<?> packet;

    public PacketEvent(class_2596<?> packet) {
        super(Event.Stage.Pre);
        this.packet = packet;
    }

    public <T extends class_2596<?>> T getPacket() {
        return (T)this.packet;
    }

    public static class Receive
    extends PacketEvent {
        public Receive(class_2596<?> packet) {
            super(packet);
        }
    }

    public static class Send
    extends PacketEvent {
        public Send(class_2596<?> packet) {
            super(packet);
        }
    }

}
