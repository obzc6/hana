/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_572
 *  net.minecraft.class_970
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_572;
import net.minecraft.class_970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_970.class})
public class MixinArmorFeatureRenderer<T extends class_1309, M extends class_572<T>, A extends class_572<T>> {
    @Inject(method={"renderArmor"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderArmor(class_4587 matrices, class_4597 vertexConsumers, T livingEntity, class_1304 equipmentSlot, int i, A bipedEntityModel, CallbackInfo ci) {
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.armor.getValue()) {
            ci.cancel();
        }
    }
}
