/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_8673
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.mod.modules.impl.miscellaneous.SilentDisconnect;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_8673;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_8673.class})
public class MixinClientCommonNetworkHandler {
    @Inject(method={"onDisconnected"}, at={@At(value="HEAD")}, cancellable=true)
    private void onDisconnected(class_2561 reason, CallbackInfo ci) {
        if (Wrapper.mc.field_1724 != null && Wrapper.mc.field_1687 != null && SilentDisconnect.INSTANCE.isOn()) {
            CommandManager.sendChatMessage("\u00a74[!] \u00a7cDisconnect! reason: \u00a77" + reason.getString());
            ci.cancel();
        }
    }

    @Inject(method={"sendPacket"}, at={@At(value="HEAD")})
    public void sendPacket(class_2596<?> packet, CallbackInfo ci) {
    }
}
