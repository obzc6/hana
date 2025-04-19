/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3191
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.WorldBreakEvent;
import net.minecraft.class_3191;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_3191.class})
public class MixinBlockBreakingInfo {
    @Inject(method={"compareTo"}, at={@At(value="HEAD")})
    public void onCompareTo(class_3191 blockBreakingInfo, CallbackInfoReturnable<Integer> cir) {
        Hana.EVENT_BUS.post(new WorldBreakEvent(blockBreakingInfo));
    }
}
