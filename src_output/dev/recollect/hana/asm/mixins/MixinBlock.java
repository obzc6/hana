/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.movement.NoSlow;
import dev.recollect.hana.mod.modules.impl.render.dev.XRay;
import net.minecraft.class_1922;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2248.class})
public abstract class MixinBlock
implements class_1935 {
    @Inject(at={@At(value="HEAD")}, method={"getVelocityMultiplier()F"}, cancellable=true)
    private void onGetVelocityMultiplier(CallbackInfoReturnable<Float> cir) {
        if (!NoSlow.INSTANCE.isOn()) {
            return;
        }
        if (cir.getReturnValueF() < 1.0f) {
            cir.setReturnValue((Object)Float.valueOf(1.0f));
        }
    }

    @Inject(method={"shouldDrawSide"}, at={@At(value="HEAD")}, cancellable=true)
    private static void shouldDrawSideHook(class_2680 state, class_1922 world, class_2338 pos, class_2350 side, class_2338 otherPos, CallbackInfoReturnable<Boolean> cir) {
        if (XRay.INSTANCE.isOn()) {
            cir.setReturnValue((Object)XRay.INSTANCE.isCheckableOre(state.method_26204()));
        }
    }

    @Inject(method={"isTransparent"}, at={@At(value="HEAD")}, cancellable=true)
    public void isTransparentHook(class_2680 state, class_1922 world, class_2338 pos, CallbackInfoReturnable<Boolean> cir) {
        if (class_310.method_1551() == null) {
            return;
        }
        if (XRay.INSTANCE.isOn()) {
            cir.setReturnValue((Object)(!XRay.INSTANCE.isCheckableOre(state.method_26204())));
        }
    }
}
