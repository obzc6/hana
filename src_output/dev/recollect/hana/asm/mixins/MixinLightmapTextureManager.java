/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_765
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.render.Ambience;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import java.awt.Color;
import net.minecraft.class_765;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={class_765.class})
public class MixinLightmapTextureManager {
    @ModifyArgs(method={"update"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/texture/NativeImage;setColor(III)V"))
    private void update(Args args) {
        if (Ambience.INSTANCE.isOn() && Ambience.INSTANCE.worldColor.booleanValue) {
            args.set(2, (Object)new Color(Ambience.INSTANCE.worldColor.getValue().getBlue(), Ambience.INSTANCE.worldColor.getValue().getGreen(), Ambience.INSTANCE.worldColor.getValue().getRed()).getRGB());
        }
    }

    @Inject(method={"getDarknessFactor(F)F"}, at={@At(value="HEAD")}, cancellable=true)
    private void getDarknessFactor(float tickDelta, CallbackInfoReturnable<Float> info) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.darkness.getValue()) {
            info.setReturnValue((Object)Float.valueOf(0.0f));
        }
    }
}
