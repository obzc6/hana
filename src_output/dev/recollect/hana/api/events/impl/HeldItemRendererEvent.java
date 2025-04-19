/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1799
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_4587;

public class HeldItemRendererEvent
extends Event {
    private final class_1268 hand;
    private final class_1799 item;
    private final float ep;
    private final class_4587 stack;

    public HeldItemRendererEvent(class_1268 hand, class_1799 item, float equipProgress, class_4587 stack) {
        super(Event.Stage.Pre);
        this.hand = hand;
        this.item = item;
        this.ep = equipProgress;
        this.stack = stack;
    }

    public class_1268 getHand() {
        return this.hand;
    }

    public class_1799 getItem() {
        return this.item;
    }

    public float getEp() {
        return this.ep;
    }

    public class_4587 getStack() {
        return this.stack;
    }
}
