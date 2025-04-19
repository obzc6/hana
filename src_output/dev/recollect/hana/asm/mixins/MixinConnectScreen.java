/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_412
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.Hana;
import dev.recollect.hana.api.events.eventbus.EventBus;
import dev.recollect.hana.api.events.eventbus.ICancellable;
import dev.recollect.hana.api.events.impl.ServerConnectBeginEvent;
import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_639;
import net.minecraft.class_642;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_412.class})
public class MixinConnectScreen {
    @Inject(method={"connect(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/network/ServerAddress;Lnet/minecraft/client/network/ServerInfo;)V"}, at={@At(value="HEAD")})
    private void tryConnectEvent(class_310 client, class_639 address, class_642 info, CallbackInfo ci) {
        ServerConnectBeginEvent event = new ServerConnectBeginEvent(address, info);
        Hana.EVENT_BUS.post(event);
    }
}
