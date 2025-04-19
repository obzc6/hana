/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.Event;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.TravelEvent;
import dev.recollect.hana.api.utils.Wrapper;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1657.class})
public class MixinPlayerEntity
implements Wrapper {
    @Inject(method={"travel"}, at={@At(value="HEAD")}, cancellable=true)
    private void onTravelPre(class_243 movementInput, CallbackInfo ci) {
        class_1657 player = (class_1657)this;
        if (player != MixinPlayerEntity.mc.field_1724) {
            return;
        }
        TravelEvent event = new TravelEvent(Event.Stage.Pre, player);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"travel"}, at={@At(value="RETURN")}, cancellable=true)
    private void onTravelPost(class_243 movementInput, CallbackInfo ci) {
        class_1657 player = (class_1657)this;
        if (player != MixinPlayerEntity.mc.field_1724) {
            return;
        }
        TravelEvent event = new TravelEvent(Event.Stage.Post, player);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }
}
