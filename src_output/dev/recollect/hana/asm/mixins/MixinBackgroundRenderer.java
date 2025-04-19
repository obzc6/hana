/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_4184
 *  net.minecraft.class_758
 *  net.minecraft.class_758$class_4596
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.recollect.hana.asm.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.recollect.hana.mod.modules.impl.render.Ambience;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.ColorSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import java.awt.Color;
import net.minecraft.class_1297;
import net.minecraft.class_4184;
import net.minecraft.class_758;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_758.class})
public class MixinBackgroundRenderer {
    @Inject(method={"applyFog"}, at={@At(value="TAIL")})
    private static void onApplyFog(class_4184 camera, class_758.class_4596 fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo info) {
        if (Ambience.INSTANCE.isOn()) {
            if (Ambience.INSTANCE.fog.booleanValue) {
                RenderSystem.setShaderFogColor((float)((float)Ambience.INSTANCE.fog.getValue().getRed() / 255.0f), (float)((float)Ambience.INSTANCE.fog.getValue().getGreen() / 255.0f), (float)((float)Ambience.INSTANCE.fog.getValue().getBlue() / 255.0f), (float)((float)Ambience.INSTANCE.fog.getValue().getAlpha() / 255.0f));
            }
            if (Ambience.INSTANCE.fogDistance.getValue()) {
                RenderSystem.setShaderFogStart((float)Ambience.INSTANCE.fogStart.getValueFloat());
                RenderSystem.setShaderFogEnd((float)Ambience.INSTANCE.fogEnd.getValueFloat());
            }
        }
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.fog.getValue() && fogType == class_758.class_4596.field_20946) {
            RenderSystem.setShaderFogStart((float)(viewDistance * 4.0f));
            RenderSystem.setShaderFogEnd((float)(viewDistance * 4.25f));
        }
    }

    @Inject(method={"getFogModifier(Lnet/minecraft/entity/Entity;F)Lnet/minecraft/client/render/BackgroundRenderer$StatusEffectFogModifier;"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onGetFogModifier(class_1297 entity, float tickDelta, CallbackInfoReturnable<Object> info) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.blindness.getValue()) {
            info.setReturnValue(null);
        }
    }
}
