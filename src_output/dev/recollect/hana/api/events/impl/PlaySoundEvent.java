/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_1113;

public class PlaySoundEvent
extends Event {
    public final class_1113 sound;

    public PlaySoundEvent(class_1113 soundInstance) {
        super(Event.Stage.Pre);
        this.sound = soundInstance;
    }
}
