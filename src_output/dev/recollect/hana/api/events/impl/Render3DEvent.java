/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4587
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_4587;

public class Render3DEvent
extends Event {
    private final float partialTicks;
    private final class_4587 matrixStack;

    public Render3DEvent(class_4587 matrixStack, float partialTicks) {
        super(Event.Stage.Pre);
        this.partialTicks = partialTicks;
        this.matrixStack = matrixStack;
    }

    public float getPartialTicks() {
        return this.partialTicks;
    }

    public class_4587 getMatrixStack() {
        return this.matrixStack;
    }
}
