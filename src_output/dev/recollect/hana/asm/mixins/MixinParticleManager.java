/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_2394
 *  net.minecraft.class_702
 *  net.minecraft.class_703
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.ParticleEvent;
import net.minecraft.class_1297;
import net.minecraft.class_2394;
import net.minecraft.class_702;
import net.minecraft.class_703;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_702.class})
public class MixinParticleManager {
    @Inject(at={@At(value="HEAD")}, method={"addParticle(Lnet/minecraft/client/particle/Particle;)V"}, cancellable=true)
    public void onAddParticle(class_703 particle, CallbackInfo ci) {
        ParticleEvent.AddParticle event = new ParticleEvent.AddParticle(particle);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"addEmitter(Lnet/minecraft/entity/Entity;Lnet/minecraft/particle/ParticleEffect;)V"}, cancellable=true)
    public void onAddEmmiter(class_1297 entity, class_2394 particleEffect, CallbackInfo ci) {
        ParticleEvent.AddEmmiter event = new ParticleEvent.AddEmmiter(particleEffect);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"addEmitter(Lnet/minecraft/entity/Entity;Lnet/minecraft/particle/ParticleEffect;I)V"}, cancellable=true)
    public void onAddEmmiterAged(class_1297 entity, class_2394 particleEffect, int maxAge, CallbackInfo ci) {
        ParticleEvent.AddEmmiter event = new ParticleEvent.AddEmmiter(particleEffect);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }
}
