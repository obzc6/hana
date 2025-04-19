/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1140
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.PlaySoundEvent;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1140.class})
public class MixinSoundSystem {
    @Inject(method={"play(Lnet/minecraft/client/sound/SoundInstance;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPlay(class_1113 soundInstance, CallbackInfo info) {
        PlaySoundEvent event = new PlaySoundEvent(soundInstance);
        Hana.EVENT_BUS.post(event);
        if (event.isCancelled()) {
            info.cancel();
        }
    }
}
