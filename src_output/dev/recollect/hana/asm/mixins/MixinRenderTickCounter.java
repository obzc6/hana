/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_317
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.TimerEvent;
import dev.recollect.hana.api.managers.TimerManager;
import net.minecraft.class_317;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_317.class})
public class MixinRenderTickCounter {
    @Shadow
    public float field_1969;

    @Inject(at={@At(value="FIELD", target="Lnet/minecraft/client/render/RenderTickCounter;prevTimeMillis:J", opcode=181, ordinal=0)}, method={"beginRenderTick(J)I"})
    public void onBeginRenderTick(long long_1, CallbackInfoReturnable<Integer> cir) {
        TimerEvent event = new TimerEvent();
        Hana.EVENT_BUS.post(event);
        if (!event.isCancelled()) {
            this.field_1969 = event.isModified() ? (this.field_1969 *= event.get()) : (this.field_1969 *= Hana.TIMER.get());
        }
    }
}
