/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2394
 *  net.minecraft.class_703
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.Event;
import net.minecraft.class_2394;
import net.minecraft.class_703;

public class ParticleEvent
extends Event {
    public ParticleEvent() {
        super(Event.Stage.Pre);
    }

    public static class AddEmmiter
    extends ParticleEvent {
        public final class_2394 emmiter;

        public AddEmmiter(class_2394 emmiter) {
            this.emmiter = emmiter;
        }
    }

    public static class AddParticle
    extends ParticleEvent {
        public final class_703 particle;

        public AddParticle(class_703 particle) {
            this.particle = particle;
        }
    }

}
