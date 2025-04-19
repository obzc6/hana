/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_583
 *  net.minecraft.class_746
 *  net.minecraft.class_922
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.recollect.hana.asm.mixins;

import dev.recollect.hana.api.managers.RotateManager;
import dev.recollect.hana.api.utils.Wrapper;
import dev.recollect.hana.api.utils.math.MathUtil;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.impl.client.CombatSetting;
import dev.recollect.hana.mod.modules.impl.render.NoRender;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import java.awt.Color;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_583;
import net.minecraft.class_746;
import net.minecraft.class_922;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_922.class})
public abstract class MixinLivingEntityRenderer<T extends class_1309, M extends class_583<T>> {
    @Unique
    private class_1309 lastEntity;
    @Unique
    private float originalYaw;
    @Unique
    private float originalHeadYaw;
    @Unique
    private float originalBodyYaw;
    @Unique
    private float originalPitch;
    @Unique
    private float originalPrevYaw;
    @Unique
    private float originalPrevHeadYaw;
    @Unique
    private float originalPrevBodyYaw;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    public void onRenderPre(T livingEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i, CallbackInfo ci) {
        if (class_310.method_1551().field_1724 != null && livingEntity == class_310.method_1551().field_1724 && CombatSetting.INSTANCE.rotations.getValue()) {
            this.originalYaw = livingEntity.method_36454();
            this.originalHeadYaw = ((class_1309)livingEntity).field_6241;
            this.originalBodyYaw = ((class_1309)livingEntity).field_6283;
            this.originalPitch = livingEntity.method_36455();
            this.originalPrevYaw = ((class_1309)livingEntity).field_5982;
            this.originalPrevHeadYaw = ((class_1309)livingEntity).field_6259;
            this.originalPrevBodyYaw = ((class_1309)livingEntity).field_6220;
            livingEntity.method_36456(RotateManager.getRenderYawOffset());
            ((class_1309)livingEntity).field_6241 = RotateManager.getRotationYawHead();
            ((class_1309)livingEntity).field_6283 = RotateManager.getRenderYawOffset();
            livingEntity.method_36457(RotateManager.getRenderPitch());
            ((class_1309)livingEntity).field_5982 = RotateManager.getPrevRenderYawOffset();
            ((class_1309)livingEntity).field_6259 = RotateManager.getPrevRotationYawHead();
            ((class_1309)livingEntity).field_6220 = RotateManager.getPrevRenderYawOffset();
            ((class_1309)livingEntity).field_6004 = RotateManager.getPrevPitch();
        }
        this.lastEntity = livingEntity;
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    public void onRenderPost(T livingEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i, CallbackInfo ci) {
        if (class_310.method_1551().field_1724 != null && livingEntity == class_310.method_1551().field_1724 && CombatSetting.INSTANCE.rotations.getValue()) {
            livingEntity.method_36456(this.originalYaw);
            ((class_1309)livingEntity).field_6241 = this.originalHeadYaw;
            ((class_1309)livingEntity).field_6283 = this.originalBodyYaw;
            livingEntity.method_36457(this.originalPitch);
            ((class_1309)livingEntity).field_5982 = this.originalPrevYaw;
            ((class_1309)livingEntity).field_6259 = this.originalPrevHeadYaw;
            ((class_1309)livingEntity).field_6220 = this.originalPrevBodyYaw;
            ((class_1309)livingEntity).field_6004 = this.originalPitch;
        }
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"))
    private void onRenderModel(class_583 entityModel, class_4587 matrices, class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        Color newColor = new Color(red, green, blue, alpha);
        if (NoRender.INSTANCE.isOn() && NoRender.INSTANCE.antiPlayerCollision.getValue() && this.lastEntity != Wrapper.mc.field_1724) {
            float overrideAlpha = (float)(Wrapper.mc.field_1724.method_5707(this.lastEntity.method_19538()) / 3.0) + 0.07f;
            newColor = ColorUtil.injectAlpha(newColor, (int)(255.0f * MathUtil.clamp(overrideAlpha, 0.0f, 1.0f)));
        }
        entityModel.method_2828(matrices, vertices, light, overlay, (float)newColor.getRed() / 255.0f, (float)newColor.getGreen() / 255.0f, (float)newColor.getBlue() / 255.0f, (float)newColor.getAlpha() / 255.0f);
    }
}
