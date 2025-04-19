/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.render.dev.XRay;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets={"me.jellysquid.mods.sodium.client.render.chunk.compile.pipeline.BlockOcclusionCache"}, remap=false)
public class MixinSodiumBlockOcclusionCache {
    @Inject(method={"shouldDrawSide"}, at={@At(value="RETURN")}, cancellable=true)
    void shouldDrawSideHook(class_2680 state, class_1922 view, class_2338 pos, class_2350 facing, CallbackInfoReturnable<Boolean> cir) {
        if (XRay.INSTANCE.isOn()) {
            cir.setReturnValue((Object)XRay.INSTANCE.isCheckableOre(state.method_26204()));
        }
    }
}
