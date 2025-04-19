/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_703
 */
package dev.recollect.hana.api.events.impl;

import dev.recollect.hana.api.events.impl.ParticleEvent;
import net.minecraft.class_703;

public static class ParticleEvent.AddParticle
extends ParticleEvent {
    public final class_703 particle;

    public ParticleEvent.AddParticle(class_703 particle) {
        this.particle = particle;
    }
}
